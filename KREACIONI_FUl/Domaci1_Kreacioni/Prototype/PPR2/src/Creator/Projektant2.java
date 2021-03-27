/* Projektant2.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 06.11.2017
 */

package Creator;

import AbstractProductA.*;
import AbstractProductB.*;
import AbstractProductC.*;

public class Projektant2 extends Projektant { //ConcreteCreator
       
    @Override
    public EkranskaForma kreirajEkranskuFormu() 
      { Panel_a pan = new Panel1_2(); // Promenljivo!!!
        EkranskaForma ef = new EkranskaForma1(); // Promenljivo!!!
        ef.setPanel(pan);
        return ef;
      }   
    
    @Override
    public BrokerBazePodataka kreirajBrokerBazePodataka () 
      { return new BrokerBazePodataka1(); // Promenljivo!!!
      }  
        
    @Override
    public Kontroler_a kreirajKontroler (EkranskaForma ef, BrokerBazePodataka bbp) 
      { return new Kontroler22(ef,bbp); // Promenljivo!!!
      }
}

