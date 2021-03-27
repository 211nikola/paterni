/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import AbstractProductA.EkranskaForma;
import AbstractProductB.BrokerBazePodataka;
import ConcreteCommand.SO;
import ConcreteCommand.SOKreiraj;
import ConcreteCommand.SONadji;
import ConcreteCommand.SOObrisi;
import ConcreteCommand.SOPromeni;
import DomainClasses.DKPrijavaClanova;
import Receiver.KreirajDomenskiObjekat;
import Receiver.NadjiDomenskiObjekat;
import Receiver.ObrisiDomenskiObjekat;
import Receiver.PromeniDomenskiObjekat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Nikola
 */
public final class Kontroler11 extends Kontroler_a{
    
   public Kontroler11(EkranskaForma ef1,BrokerBazePodataka bbp1,SO so)
    {ef=ef1;bbp=bbp1; Povezi(so);}
    
    void Povezi(SO so)
    {
      
      KreirajDomenskiObjekat kdo = new KreirajDomenskiObjekat(this);
      so.sok = new SOKreiraj(kdo); // povezivanje ConcreteCommand i Receiver
           
      PromeniDomenskiObjekat pdo = new PromeniDomenskiObjekat(this);
      so.sop = new SOPromeni(pdo); 
            
      ObrisiDomenskiObjekat odo = new ObrisiDomenskiObjekat(this);
      so.soo = new SOObrisi(odo); 
            
      
      NadjiDomenskiObjekat ndo = new NadjiDomenskiObjekat(this);
      so.son = new SONadji(ndo); 
          
     
    }
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
    
    public void isprazniGrafickiObjekat(){
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
    
}
