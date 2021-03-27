
package Receiver;


import Client.Kontroler_a;
import DomainClasses.DKPrijavaClanova;
import java.util.concurrent.atomic.AtomicInteger;

 public class KreirajDomenskiObjekat { // Receiver
    
   Kontroler_a kon;
     
    public KreirajDomenskiObjekat(Kontroler_a kon1){kon=kon1;} 
     
    public boolean kreirajDomenskiObjekat(){
    boolean signal;
    DKPrijavaClanova ip= new DKPrijavaClanova(); // Promenljivo!!!
    AtomicInteger counter = new AtomicInteger(0);
    
    kon.getBrokerBazePodataka().makeConnection();
    if (!kon.getBrokerBazePodataka().getCounter(ip,counter)) return false;
    if (!kon.getBrokerBazePodataka().increaseCounter(ip,counter)) return false;
          
    ip.setSifraPrijave(counter.get()); // Promenljivo!!!
    signal = kon.getBrokerBazePodataka().insertRecord(ip);
    if (signal==true) 
        { kon.getBrokerBazePodataka().commitTransation();
          kon.napuniGrafickiObjekatIzDomenskogObjekta(ip);
          kon.setPoruka("Систем је креирао нову испитну пријаву."); // Promenljivo!!!
        }
        else
        { kon.getBrokerBazePodataka().rollbackTransation();
         kon.isprazniGrafickiObjekat();
         kon.setPoruka("Систем не може да креира нову испитну пријаву."); // Promenljivo!!!
        }
    kon.prikaziPoruku();
    kon.getBrokerBazePodataka().closeConnection();
    return signal;
}
    
}
