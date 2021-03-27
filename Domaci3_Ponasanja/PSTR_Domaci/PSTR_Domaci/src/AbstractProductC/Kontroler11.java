/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractProductC;

import AbstractProductA.EkranskaForma;
import AbstractProductB.BrokerBazePodataka;
import ConcreteStrategy.KreirajDomenskiObjekat;
import ConcreteStrategy.NadjiDomenskiObjekat;
import ConcreteStrategy.ObrisiDomenskiObjekat;
import ConcreteStrategy.PromeniDomenskiObjekat;
import Context.Dugme;
import Context.TekstPolje;
import DomainClasses.DKPrijavaClanova;
import DomainClasses.GeneralDObject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Nikola
 */
public final class Kontroler11 extends Kontroler_a{
    
    public Kontroler11(EkranskaForma ef1,BrokerBazePodataka bbp1){ef=ef1;bbp=bbp1; Povezi();}
    
    void Povezi()
    {
      
      KreirajDomenskiObjekat kdo = new KreirajDomenskiObjekat(bbp,this);
      Dugme dk1 = new Dugme(kdo,ef.getPanel().getKreiraj()); 
      
      PromeniDomenskiObjekat pdo = new PromeniDomenskiObjekat(bbp,this);
      Dugme dk2 = new Dugme(pdo,ef.getPanel().getPromeni());
      
      ObrisiDomenskiObjekat odo = new ObrisiDomenskiObjekat(bbp,this);
      Dugme dk3 = new Dugme(odo,ef.getPanel().getObrisi());
      
      
      NadjiDomenskiObjekat ndo = new NadjiDomenskiObjekat(bbp,this);
      Dugme dk4 = new Dugme(ndo,ef.getPanel().getNadji());
      
      
      TekstPolje tp = new TekstPolje(ndo,ef.getPanel().getSifraPrijave1());
         
     
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

    @Override
    public void napuniGrafickiObjekatIzDomenskogObjekta(GeneralDObject gdo) {
        ef.getPanel().setSifrraPrijave(Integer.toString(pc.getSifraPrijave()));
       ef.getPanel().setIme(pc.getIme());
       ef.getPanel().setPrezime(pc.getPrezime());
       ef.getPanel().setPozicija(pc.getPozicija());
       ef.getPanel().setDatum(pc.getDatum());
    }
    
    
    
    @Override
    public void isprazniGrafickiObjekat(){
        ef.getPanel().setSifrraPrijave("");
        ef.getPanel().setIme("");
        ef.getPanel().setPrezime("");
        ef.getPanel().setPozicija("BackEnd");
        ef.getPanel().setDatum(new Date());
    }
    
    
    @Override
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
