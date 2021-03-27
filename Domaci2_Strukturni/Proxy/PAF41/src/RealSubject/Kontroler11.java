/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RealSubject;

import AbstractProductA.EkranskaForma;
import AbstractProductB.BrokerBazePodataka;
import DomainClasses.DKPrijavaClanova;
import Subject.Kontroler_a;
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

    private void Povezi() {
        
        JButton Kreiraj = ef.getPanel().getKreiraj();
        JButton Promeni = ef.getPanel().getPromeni();
        JButton Obrisi = ef.getPanel().getObrisi();
        JButton Nadji = ef.getPanel().getNadji();
        
        Kreiraj.addActionListener( new OsluskivacKreiraj(this));
        Promeni.addActionListener( new OsluskivacPromeni(this));
        Obrisi.addActionListener( new OsluskivacObrisi(this));
        Nadji.addActionListener( new OsluskivacNadji(this));
        
        javax.swing.JTextField SifraPrijave = ef.getPanel().getSifraPrijave1(); // Promenljivo!!!
        SifraPrijave.addFocusListener( new OsluskivacNadji1(this));
        
    }
    @Override
    public void napuniDomenskiObjekatIzGrafickogObjekta()   {
       pc= new DKPrijavaClanova();
       pc.setSifraPrijave(getInteger(ef.getPanel().getSifraPrijave()));
       pc.setIme(ef.getPanel().getIme());
       pc.setPrezime(ef.getPanel().getPrezime());
       pc.setPozicija((ef.getPanel().getPozicija()));
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       java.util.Date Datum = java.sql.Date.valueOf(sdf.format(ef.getPanel().getDatum())); 
       pc.setDatum(Datum); 
    
    }
    
    void napuniGrafickiObjekatIzDomenskogObjekta(DKPrijavaClanova pc){
       ef.getPanel().setSifrraPrijave(Integer.toString(pc.getSifraPrijave()));
       ef.getPanel().setIme(pc.getIme());;
       ef.getPanel().setPrezime(pc.getPrezime());
       ef.getPanel().setPozicija(pc.getPozicija().toString());
       ef.getPanel().setDatum(pc.getDatum());
      
    }
    
    void isprazniGrafickiObjekat(){
        ef.getPanel().setSifrraPrijave("");
        ef.getPanel().setIme("");
        ef.getPanel().setPrezime("");
        ef.getPanel().setPozicija("BackEnd");
        ef.getPanel().setDatum(new Date());
    }
    
    
    void prikaziPoruku() {
        
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
    
    @Override
    public boolean zapamtiDomenskiObjekat(){ 
    
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
    
    @Override
    public boolean kreirajDomenskiObjekat(){
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
    
    @Override
    public boolean obrisiDomenskiObjekat(){
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
    
    @Override
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
    
    @Override
    public boolean nadjiDomenskiObjekat(){
    boolean signal;
    bbp.makeConnection();
    pc = (DKPrijavaClanova)bbp.findRecord(pc); 
    if (pc != null) 
        { napuniGrafickiObjekatIzDomenskogObjekta(pc);
          poruka = "Sistem je nasao prijacu clana."; 
          signal = true;
        }
        else
        { isprazniGrafickiObjekat();
          poruka ="Sistem ne moze da nadje prijavu clana."; 
          signal = false;
        }
    prikaziPoruku();
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
