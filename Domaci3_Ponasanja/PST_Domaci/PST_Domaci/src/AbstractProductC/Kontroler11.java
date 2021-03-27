/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractProductC;

import AbstractProductA.EkranskaForma;
import AbstractProductB.BrokerBazePodataka;
import ConcreteState.Neobradjen;
import ConcreteState.NullStanje;
import ConcreteState.Obradjen;
import ConcreteState.Storniran;
import DomainClasses.DKPrijavaClanova;
import State.Stanje;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.JButton;

/**
 *
 * @author Nikola
 */
public class Kontroler11 extends Kontroler_a{
    
    public Kontroler11(EkranskaForma ef1,BrokerBazePodataka bbp1){
        ef=ef1;bbp=bbp1; Povezi();
    }

    void Povezi()
    {javax.swing.JButton Kreiraj = ef.getPanel().getKreiraj();
     javax.swing.JButton Promeni = ef.getPanel().getPromeni();
     javax.swing.JButton Obradi = ef.getPanel().getObradi();
     javax.swing.JButton Storniraj = ef.getPanel().getStorniraj();
     javax.swing.JButton Nadji = ef.getPanel().getNadji();
     Kreiraj.addActionListener( new OsluskivacKreiraj(this));
     Promeni.addActionListener( new OsluskivacPromeni(this));
     Obradi.addActionListener( new OsluskivacObradi(this));
     Storniraj.addActionListener( new OsluskivacStorniraj(this));
     Nadji.addActionListener( new OsluskivacNadji(this));
     
     javax.swing.JTextField SifraPrijave = ef.getPanel().getSifraPrijave1(); // Promenljivo!!!
     SifraPrijave.addFocusListener( new OsluskivacNadji1(this));
    }
    void napuniDomenskiObjekatIzGrafickogObjekta()   {
       pc= new DKPrijavaClanova();
       pc.setSifraPrijave(getInteger(ef.getPanel().getSifraPrijave()));
       pc.setIme(ef.getPanel().getIme());
       pc.setPrezime(ef.getPanel().getPrezime());
       pc.setPozicija((ef.getPanel().getPozicija()));
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       java.util.Date Datum = java.sql.Date.valueOf(sdf.format(ef.getPanel().getDatum())); 
       pc.setDatum(Datum); 
    
    }
    
    public void napuniGrafickiObjekatIzDomenskogObjekta(DKPrijavaClanova pc){
       ef.getPanel().setSifrraPrijave(Integer.toString(pc.getSifraPrijave()));
       ef.getPanel().setIme(pc.getIme());;
       ef.getPanel().setPrezime(pc.getPrezime());
       ef.getPanel().setPozicija(pc.getPozicija().toString());
       ef.getPanel().setDatum(pc.getDatum());
      
    }
    public boolean nadjiDomenskiObjekat(){
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
    
    void isprazniGrafickiObjekat(){
        ef.getPanel().setSifrraPrijave("");
        ef.getPanel().setIme("");
        ef.getPanel().setPrezime("");
        ef.getPanel().setPozicija("BackEnd");
        ef.getPanel().setDatum(new Date());
    }
    
    
    public void prikaziPoruku() {
        
        ef.getPanel().setPoruka(poruka);
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
    
    boolean zapamtiDomenskiObjekat(){ 
    
    bbp.makeConnection();
    boolean signal = bbp.insertRecord(pc);
    if (signal==true) 
        { bbp.commitTransation();
          poruka ="Sistem je zapamtio novog clana."; 
        }
        else
        { bbp.rollbackTransation();
          poruka ="Sistem ne moze da zapamti novog clana.";   
        }
    prikaziPoruku();
    bbp.closeConnection();
    return signal; 
       
    }
    
    boolean kreirajDomenskiObjekat(){
    boolean signal;
    pc= new DKPrijavaClanova(); 
    AtomicInteger counter = new AtomicInteger(0);
    
    bbp.makeConnection();
    if (!bbp.getCounter(pc,counter)) return false;
    if (!bbp.increaseCounter(pc,counter)) return false;
          
    pc.setSifraPrijave(counter.get()); 
    signal = bbp.insertRecord(pc);
    if (signal==true) 
        { bbp.commitTransation();
          napuniGrafickiObjekatIzDomenskogObjekta(pc);
          poruka = "Sistem je kreirao novog clana."; 
        }
        else
        { bbp.rollbackTransation();
        isprazniGrafickiObjekat();
        poruka ="Sistem ne moze da kreira novog clana."; // Promenljivo!!!
        }
    prikaziPoruku();
    bbp.closeConnection();
    return signal;
    }
    
    boolean obrisiDomenskiObjekat(){
    bbp.makeConnection();
    boolean signal = bbp.deleteRecord(pc);
    if (signal==true) 
        { bbp.commitTransation();
          poruka = "Sistem je obrisao clana."; 
            isprazniGrafickiObjekat();
        }
        else
        { bbp.rollbackTransation();
          poruka = "Sistem ne moze da obrise clana."; 
        }
    prikaziPoruku();
    bbp.closeConnection();
    return signal;   
    }
    
    public boolean promeniDomenskiObjekat(){
    bbp.makeConnection();
    boolean signal = bbp.updateRecord(pc);
    if (signal==true) 
        { bbp.commitTransation();
          poruka = "Sistem je promenio clana."; 
        }
        else
        { bbp.rollbackTransation();
          isprazniGrafickiObjekat();
          poruka = "Sistem ne moze da promeni clana."; // Promenljivo!!!
        }
    prikaziPoruku();
    bbp.closeConnection();
    return signal;      
    }
    
    Stanje odrediStanjeIspitnePrijave()
{
    bbp.makeConnection();
    Stanje st = null;
    DKPrijavaClanova ip1 = (DKPrijavaClanova)bbp.findRecord(pc);
    bbp.closeConnection();
    if (ip1 != null) 
        { if (ip1.getStanje().equals("obradjen")) {st = new Obradjen(this);} 
          if (ip1.getStanje().equals("neobradjen")) {st = new Neobradjen(this);}
          if (ip1.getStanje().equals("storniran")) {st = new Storniran(this);} 
        }
        else
        {  st = new NullStanje(this);
        }
    return st;
}

void obradiDomenskiObjekat(){
    Stanje st = odrediStanjeIspitnePrijave();
    st.obradiDomenskiObjekat();
}
void stornirajDomenskiObjekat(){
    Stanje st = odrediStanjeIspitnePrijave();
    st.stornirajDomenskiObjekat();
}

    @Override
 public boolean nadjiDomenskiObjekat1(){
    boolean signal;
    bbp.makeConnection();
    pc = (DKPrijavaClanova)bbp.findRecord(pc); 
    if (pc != null) 
        { napuniGrafickiObjekatIzDomenskogObjekta(pc);
          signal = true;
        }
        else
        { isprazniGrafickiObjekat();
          signal = false;
        }
    bbp.closeConnection();
    return signal;   
}
    
   
    
    
    class OsluskivacZapamti implements ActionListener{   Kontroler11 kon;
 
    OsluskivacZapamti(Kontroler11 kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.zapamtiDomenskiObjekat();
        
    }
}

class OsluskivacKreiraj implements ActionListener
{   Kontroler11 kon;
 
    OsluskivacKreiraj(Kontroler11 kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.kreirajDomenskiObjekat();
         
        
    }
}
class OsluskivacStorniraj implements ActionListener
{   Kontroler11 kon;
 
    OsluskivacStorniraj(Kontroler11 kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.stornirajDomenskiObjekat();
        
    }
}

class OsluskivacObrisi implements ActionListener{ 
    Kontroler11 kon;
 
    OsluskivacObrisi(Kontroler11 kon1) {kon = kon1;}
    
    @Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.obrisiDomenskiObjekat();
        
    }
}

class OsluskivacPromeni implements ActionListener{
    Kontroler11 kon;
 
    OsluskivacPromeni(Kontroler11 kon1) {kon = kon1;}
    
    @Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.promeniDomenskiObjekat();
        
         }
    }

class OsluskivacNadji implements ActionListener{
    
    Kontroler11 kon;
 
    OsluskivacNadji(Kontroler11 kon1) {kon = kon1;}
    
    @Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.nadjiDomenskiObjekat();
        
             }
    }

class OsluskivacObradi implements ActionListener
{   Kontroler11 kon;
 
    OsluskivacObradi(Kontroler11 kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.obradiDomenskiObjekat();
        
    }
}

class OsluskivacNadji1 implements FocusListener{  
    
    Kontroler11 kon;
 
    OsluskivacNadji1(Kontroler11 kon1) {kon = kon1;}
    

    @Override
    public void focusLost(java.awt.event.FocusEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.nadjiDomenskiObjekat();
        
        }

    @Override
    public void focusGained(FocusEvent e) {
        
         }
    
    
    
    }  
}
