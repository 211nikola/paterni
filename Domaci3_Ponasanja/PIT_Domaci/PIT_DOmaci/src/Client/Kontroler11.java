/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import AbstractProductA.EkranskaForma;
import AbstractProductB.BrokerBazePodataka;
import ConcreteCommand.SOKreiraj;
import ConcreteCommand.SONadji;
import ConcreteCommand.SOObrisi;
import ConcreteCommand.SOPromeni;
import DomainClasses.DKPrijavaClanova;
import Invoker.Dugme;
import Invoker.TekstPolje;
import Iterator.DugmeKretanja;
import Receiver.KreirajDomenskiObjekat;
import Receiver.NadjiDomenskiObjekat;
import Receiver.ObrisiDomenskiObjekat;
import Receiver.PromeniDomenskiObjekat;
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
      SOKreiraj sok = new SOKreiraj(kdo); // povezivanje ConcreteCommand and Receiver
      Dugme dk1 = new Dugme(sok,ef.getPanel().getKreiraj());
      
      PromeniDomenskiObjekat pdo = new PromeniDomenskiObjekat(bbp,this);
      SOPromeni sop = new SOPromeni(pdo); // povezivanje ConcreteCommand and Receiver
      Dugme dk2 = new Dugme(sop,ef.getPanel().getPromeni());
      
      ObrisiDomenskiObjekat odo = new ObrisiDomenskiObjekat(bbp,this);
      SOObrisi soo = new SOObrisi(odo); // povezivanje ConcreteCommand and Receiver
      Dugme dk3 = new Dugme(soo,ef.getPanel().getObrisi());
      
      
      NadjiDomenskiObjekat ndo = new NadjiDomenskiObjekat(bbp,this);
      SONadji son = new SONadji(ndo); // povezivanje ConcreteCommand and Receiver
      Dugme dk4 = new Dugme(son,ef.getPanel().getNadji());
      
      
      TekstPolje tp = new TekstPolje(son,ef.getPanel().getSifraPrijave1());
      
      it = bbp.getIterator(new DKPrijavaClanova());
      DugmeKretanja dprv = new DugmeKretanja(it,ef.getPanel().getPrvi(),this);
      DugmeKretanja dsl = new DugmeKretanja(it,ef.getPanel().getSledeci(),this);
      DugmeKretanja dpre = new DugmeKretanja(it,ef.getPanel().getPredhodni(),this);
      DugmeKretanja dza = new DugmeKretanja(it,ef.getPanel().getZadnji(),this);
      
     
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
