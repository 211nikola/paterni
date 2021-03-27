/* KreirajDomenskiObjekat.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 06.11.2017
 */

package ConcreteClass;

import AbstractClass.OpstaDBSO;
import AbstractProductB.BrokerBazePodataka;
import Client.Kontroler_a;
import DomainClasses.DKPrijavaClanova;
import DomainClasses.GeneralDObject;
import java.util.concurrent.atomic.AtomicInteger;


public class KreirajDomenskiObjekat extends OpstaDBSO{ // ConcreteClass

    public KreirajDomenskiObjekat(BrokerBazePodataka bbp1,Kontroler_a kon1) {super(bbp1,kon1);}
    
    
    @Override
    public void  makeConnection() {bbp.makeConnection();} 
    
    @Override
    public boolean konkretnaDBSO() // insert record
{     kon.isprazniGrafickiObjekat();
      GeneralDObject ip = kon.getDomenskiObjekat();
      AtomicInteger counter = new AtomicInteger(0);
    
      if (!bbp.getCounter(ip,counter)) return false;
      if (!bbp.increaseCounter(ip,counter)) return false;
          
      ((DKPrijavaClanova)ip).setSifraPrijave(counter.get()); // Promenljivo!!!
      
      return bbp.insertRecord(ip);

}
    @Override
    public void uspesnaDBOperacija()
    { bbp.commitTransation();
      kon.setPoruka("Систем је креирао нову испитну пријаву.");
      kon.napuniGrafickiObjekatIzDomenskogObjekta(kon.getDomenskiObjekat());
    }

    @Override
    public void neuspesnaDBOperacija()
     { bbp.rollbackTransation();
       kon.isprazniGrafickiObjekat();
       kon.setPoruka("Систем не може да креира нову испитну пријаву.");
     }
    
}
