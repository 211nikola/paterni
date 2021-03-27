/* Projektant1.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 06.11.2017
 */

package AbstractFactory;

import Abstraction.BrokerBazePodataka;
import Abstraction.BrokerBazePodataka2;
import AbstractProductA.*;
import AbstractProductC.*;

// Promenljivo!!!
public class Projektant1 implements Projektant {
        
    @Override
    public EkranskaForma kreirajEkranskuFormu() {
        Panel1_1 pan = new Panel1_1(); 
        EkranskaForma2 pc = new EkranskaForma2(); 
        pc.setPanel(pan);
        return pc;
    }   
    
    @Override
    public BrokerBazePodataka kreirajBrokerBazePodataka () 
      { BrokerBazePodataka dbbr = new BrokerBazePodataka2(); 
        return dbbr;}  
    
    @Override
    public Kontroler_a kreirajKontroler (EkranskaForma ef,BrokerBazePodataka dbbr) {
        Kontroler_a kon = new Kontroler11(ef,dbbr); // Promenljivo!!!
        return kon;
    }
        
   
}

