/* KreirajDomenskiObjekat.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 02.12.2017
 */

package ConcreteStrategy;

import AbstractProductB.BrokerBazePodataka;
import AbstractProductC.Kontroler_a;
import DomainClasses.DKPrijavaClanova;
import Strategy.SistemskaOperacija;
import java.util.concurrent.atomic.AtomicInteger;

 public class KreirajDomenskiObjekat implements  SistemskaOperacija{ // Receiver
    
    BrokerBazePodataka bbp;
    Kontroler_a kon;
     
    public KreirajDomenskiObjekat(BrokerBazePodataka bbp1,Kontroler_a kon1){bbp=bbp1;kon=kon1;} 
     
    @Override
    public boolean izvrsiSO(){
    boolean signal;
    DKPrijavaClanova ip= new DKPrijavaClanova(); // Promenljivo!!!
    AtomicInteger counter = new AtomicInteger(0);
    
    bbp.makeConnection();
    if (!bbp.getCounter(ip,counter)) return false;
    if (!bbp.increaseCounter(ip,counter)) return false;
          
    ip.setSifraPrijave(counter.get()); // Promenljivo!!!
    signal = bbp.insertRecord(ip);
    if (signal==true) 
        { bbp.commitTransation();
          kon.napuniGrafickiObjekatIzDomenskogObjekta(ip);
          kon.setPoruka("Систем је креирао нову испитну пријаву."); // Promenljivo!!!
        }
        else
        { bbp.rollbackTransation();
        kon.isprazniGrafickiObjekat();
         kon.setPoruka("Систем не може да креира нову испитну пријаву."); // Promenljivo!!!
        }
    kon.prikaziPoruku();
    bbp.closeConnection();
    return signal;
}
    
}
