/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import AbstractProductA.EkranskaForma;
import AbstractProductB.BrokerBazePodataka;
import Colleaque.CloseConnection;
import Colleaque.DBOperation;
import Colleaque.KreirajDomenskiObjekat;
import Colleaque.MakeConnection;
import Colleaque.NadjiDomenskiObjekat;
import Colleaque.ObrisiDomenskiObjekat;
import Colleaque.PromeniDomenskiObjekat;
import Colleaque.UspesnostDBOperacije;
import ConcreteCommand.SOKreiraj;
import ConcreteCommand.SONadji;
import ConcreteCommand.SOObrisi;
import ConcreteCommand.SOPromeni;
import DomainClasses.DKPrijavaClanova;
import DomainClasses.GeneralDObject;
import Invoker.Dugme;
import Invoker.TekstPolje;
import Mediator.ConcreteMediator;
import Mediator.Mediator;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Nikola
 */
public final class Kontroler11 extends Kontroler_a{
    
    public Kontroler11(EkranskaForma ef1,BrokerBazePodataka bbp1){
        ef=ef1;bbp=bbp1; Povezi();
    }

    void Povezi()
    {
      MakeConnection mk = new MakeConnection(bbp,this); 
      UspesnostDBOperacije udbo = new UspesnostDBOperacije(bbp,this);
      CloseConnection cc = new CloseConnection(bbp,this);
      DBOperation dbo = new DBOperation(bbp,this);  
        
      Mediator med = new ConcreteMediator(mk,udbo,cc,dbo);
      
      KreirajDomenskiObjekat kdo = new KreirajDomenskiObjekat(bbp,this,med);
      SOKreiraj sok = new SOKreiraj(kdo); // povezivanje ConcreteCommand i Receiver
      Dugme dk1 = new Dugme(sok,ef.getPanel().getKreiraj()); // povezivanje Client i ConcreteCommand 
      
      PromeniDomenskiObjekat pdo = new PromeniDomenskiObjekat(bbp,this,med);
      SOPromeni sop = new SOPromeni(pdo); 
      Dugme dk2 = new Dugme(sop,ef.getPanel().getPromeni());
      
      ObrisiDomenskiObjekat odo = new ObrisiDomenskiObjekat(bbp,this,med);
      SOObrisi soo = new SOObrisi(odo); 
      Dugme dk3 = new Dugme(soo,ef.getPanel().getObrisi());
      
      
      NadjiDomenskiObjekat ndo = new NadjiDomenskiObjekat(bbp,this,med);
      SONadji son = new SONadji(ndo); 
      Dugme dk4 = new Dugme(son,ef.getPanel().getNadji());
      
      
      TekstPolje tp = new TekstPolje(son,ef.getPanel().getSifraPrijave1());
         
     
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
    public void napuniDomenskiObjekatIzGrafickogObjekta() {
        pc = new DKPrijavaClanova();
        pc.setSifraPrijave(getInteger(ef.getPanel().getSifraPrijave()));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       java.util.Date Datum = java.sql.Date.valueOf(sdf.format(ef.getPanel().getDatum())); 
       pc.setDatum(Datum); 
       pc.setPozicija(ef.getPanel().getPozicija());
       pc.setIme(ef.getPanel().getIme());
       pc.setPrezime(ef.getPanel().getPrezime());
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
