/* Kontroler1.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 06.11.2017
 */

package ConcreteComponent;



import AbstractProductA.*;
import AbstractProductB.*;
import Component.Kontroler;
import ConcreteVisitor.VisitorKreiraj;
import ConcreteVisitor.VisitorNadji;
import ConcreteVisitor.VisitorObrisi;
import ConcreteVisitor.VisitorPromeni;
import ConcreteVisitor.VisitorZapamti;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Timer;
import java.util.TimerTask;
import DomainClasses.DKPrijavaClanova;  // Promenljivo
import Visitor.Visitor;
import java.util.Date;


public final class Kontroler1 extends Kontroler{ // ConcreteComponent
   
    
   
    boolean promeni = true;
    boolean zapamti = true;
    boolean nadji = true;
    boolean obrisi = true;
    boolean kreiraj = true;
    
    public Kontroler1(EkranskaForma ef1,BrokerBazePodataka bbp1){ef=ef1;bbp=bbp1; Povezi(null);}
    
     
    @Override
    public void Povezi(Kontroler kon)
    {
     
     if (kon != null) 
     {   
         javax.swing.JButton Kreiraj = ef.getPanel().getKreiraj();
         javax.swing.JButton Promeni = ef.getPanel().getPromeni();
         javax.swing.JButton Obrisi = ef.getPanel().getObrisi();
         javax.swing.JButton Nadji = ef.getPanel().getNadji();
         Kreiraj.addActionListener( new OsluskivacKreiraj(kon));
         Promeni.addActionListener( new OsluskivacPromeni(kon));
         Obrisi.addActionListener( new OsluskivacObrisi(kon));
         Nadji.addActionListener( new OsluskivacNadji(kon));
        javax.swing.JTextField SifraPrijave = ef.getPanel().getSifraPrijave1(); // Promenljivo!!!
        SifraPrijave.addFocusListener( new OsluskivacNadji1(kon));
     }   
    }
    
    // Promenljivo!!!  
    public void napuniDomenskiObjekatIzGrafickogObjekta()   {
        
       DKPrijavaClanova pc= new DKPrijavaClanova();
       pc.setSifraPrijave(getInteger(ef.getPanel().getSifraPrijave()));
       pc.setIme(ef.getPanel().getIme());
       pc.setPrezime(ef.getPanel().getPrezime());
       pc.setPozicija((ef.getPanel().getPozicija()));
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       java.util.Date Datum = java.sql.Date.valueOf(sdf.format(ef.getPanel().getDatum())); 
       pc.setDatum(Datum);  
    
    }

    // Promenljivo!!!
    public void napuniGrafickiObjekatIzDomenskogObjekta(DKPrijavaClanova pc){
       ef.getPanel().setSifrraPrijave(Integer.toString(pc.getSifraPrijave()));
       ef.getPanel().setIme(pc.getIme());;
       ef.getPanel().setPrezime(pc.getPrezime());
       ef.getPanel().setPozicija(pc.getPozicija().toString());
       ef.getPanel().setDatum(pc.getDatum());
      
    }

// Promenljivo!!!
public void isprazniGrafickiObjekat(){
        ef.getPanel().setSifrraPrijave("");
        ef.getPanel().setIme("");
        ef.getPanel().setPrezime("");
        ef.getPanel().setPozicija("BackEnd");
        ef.getPanel().setDatum(new Date());
}

public void prikaziPoruku() 
{ ef.getPanel().setPoruka(poruka);
      
  Timer timer = new Timer();
  
  timer.schedule(new TimerTask() {
  @Override
  public void run() {
    ef.getPanel().setPoruka(""); 
  }
}, 3000);
  
}

public int getInteger(String s) {
    int broj = 0;
    try
        {
            if(s != null)
                broj = Integer.parseInt(s);
        }
            catch (NumberFormatException e)
            { broj = 0;}
   
    return broj;
}
public void Promeni(boolean promeni1){promeni=promeni1;}
public void Zapamti(boolean zapamti1){zapamti=zapamti1;}
public void Nadji(boolean nadji1){nadji=nadji1;}
public void Obrisi(boolean obrisi1){obrisi=obrisi1;}
public void Kreiraj(boolean kreiraj1){kreiraj=kreiraj1;}

    @Override
    public boolean zapamtiDomenskiObjekat(Visitor vis) {
     bbp.makeConnection();
    boolean signal = bbp.insertRecord(pc);
    if (signal==true) 
        { bbp.commitTransation();
          poruka ="Систем је запамтио нову испитну пријаву."; // Promenljivo!!!
        }
        else
        { bbp.rollbackTransation();
          poruka ="Систем не може да запамти нову испитну пријаву."; // Promenljivo!!!  
        }
    prikaziPoruku();
    bbp.closeConnection();
    return signal; 
    }

    @Override
    public boolean kreirajDomenskiObjekat(Visitor vis) {
        boolean signal;
    pc= new DKPrijavaClanova(); // Promenljivo!!!
    AtomicInteger counter = new AtomicInteger(0);
    
    bbp.makeConnection();
    if (!bbp.getCounter(pc,counter)) return false;
    if (!bbp.increaseCounter(pc,counter)) return false;
          
    pc.setSifraPrijave(counter.get()); // Promenljivo!!!
    signal = bbp.insertRecord(pc);
    if (signal==true) 
        { bbp.commitTransation();
          napuniGrafickiObjekatIzDomenskogObjekta(pc);
          poruka = "Систем је креирао нову испитну пријаву."; // Promenljivo!!!
        }
        else
        { bbp.rollbackTransation();
        isprazniGrafickiObjekat();
        poruka ="Систем не може да креира нову испитну пријаву."; // Promenljivo!!!
        }
    prikaziPoruku();
    bbp.closeConnection();
    return signal;
    }

    @Override
    public boolean obrisiDomenskiObjekat(Visitor vis) {
    bbp.makeConnection();
    boolean signal = bbp.deleteRecord(pc);
    if (signal==true) 
        { bbp.commitTransation();
          poruka = "Систем je oбрисао испитну пријаву."; // Promenljivo!!!
            isprazniGrafickiObjekat();
        }
        else
        { bbp.rollbackTransation();
          poruka = "Систем не може да обрише испитну пријаву."; // Promenljivo!!!
        }
    prikaziPoruku();
    bbp.closeConnection();
    return signal;       }

    @Override
    public boolean promeniDomenskiObjekat(Visitor vis) {
         bbp.makeConnection();
    boolean signal = bbp.updateRecord(pc);
    if (signal==true) 
        { bbp.commitTransation();
          poruka = "Систем je променио испитну пријаву."; // Promenljivo!!!
        }
        else
        { bbp.rollbackTransation();
          isprazniGrafickiObjekat();
          poruka = "Систем не може да промени испитну пријаву."; // Promenljivo!!!
        }
    prikaziPoruku();
    bbp.closeConnection();
    return signal;   
    }

    @Override
    public boolean nadjiDomenskiObjekat(Visitor vis) {
        boolean signal;
    bbp.makeConnection();
    pc = (DKPrijavaClanova)bbp.findRecord(pc); // Promenljivo!!!
    if (pc != null) 
        { napuniGrafickiObjekatIzDomenskogObjekta(pc);
          poruka = "Систем je нашао испитну пријаву."; // Promenljivo!!!
          signal = true;
        }
        else
        { isprazniGrafickiObjekat();
          poruka ="Систем не може да нађе испитну пријаву."; // Promenljivo!!!
          signal = false;
        }
    prikaziPoruku();
    bbp.closeConnection();
    return signal;   
    }

 

 

    








   
}



class OsluskivacZapamti implements ActionListener
{   Kontroler kon;
 
    OsluskivacZapamti(Kontroler1 kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.zapamtiDomenskiObjekat(new VisitorZapamti());
        
    }
}

class OsluskivacKreiraj implements ActionListener
{   Kontroler kon;
 
    OsluskivacKreiraj(Kontroler kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.kreirajDomenskiObjekat(new VisitorKreiraj());
         
        
    }
}

class OsluskivacObrisi implements ActionListener
{   Kontroler kon;
 
    OsluskivacObrisi(Kontroler kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.obrisiDomenskiObjekat(new VisitorObrisi());
        
    }
}

class OsluskivacPromeni implements ActionListener
{   Kontroler kon;
 
    OsluskivacPromeni(Kontroler kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.promeniDomenskiObjekat(new VisitorPromeni());
        
    }
}

class OsluskivacNadji implements ActionListener
{   Kontroler kon;
 
    OsluskivacNadji(Kontroler kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.nadjiDomenskiObjekat(new VisitorNadji());
        
    }
}

class OsluskivacNadji1 implements FocusListener
{   Kontroler kon;
 
    OsluskivacNadji1(Kontroler kon1) {kon = kon1;}
    

    @Override
    public void focusLost(java.awt.event.FocusEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.nadjiDomenskiObjekat(new VisitorNadji());
    }

    @Override
    public void focusGained(FocusEvent e) {
        
    }
}