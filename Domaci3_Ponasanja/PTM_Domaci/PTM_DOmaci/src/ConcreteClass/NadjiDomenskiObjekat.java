/* NadjiDomenskiObjekat.java
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
import DomainClasses.GeneralDObject;


public class NadjiDomenskiObjekat extends OpstaDBSO{ // ConcreteClass

    public NadjiDomenskiObjekat(BrokerBazePodataka bbp1,Kontroler_a kon1) {super(bbp1,kon1);}
    
    
       
    @Override
    public boolean konkretnaDBSO() // find record
   { GeneralDObject gdo = bbp.findRecord(kon.getDomenskiObjekat());
     if (gdo!=null) kon.setDomenskiObjekat(gdo);
     else kon.isprazniGrafickiObjekat();
     return (gdo!=null);}
    
    @Override
    public void uspesnaDBOperacija()
    { kon.napuniGrafickiObjekatIzDomenskogObjekta(kon.getDomenskiObjekat());
      kon.setPoruka("Систем je нашао испитну пријаву."); 
    }

    @Override
    public void neuspesnaDBOperacija()
     { kon.isprazniGrafickiObjekat();
       kon.setPoruka("Систем не може да нађе испитну пријаву."); 
     }
    
     
}
