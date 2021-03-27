/* Projektant1.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 06.11.2017
 */

package AbstractFactory;

import AbstractProductA.*;
import AbstractProductB.*;
import ConcreteHandler.Kontroler11;
import Handler.Kontroler_a;

// Promenljivo!!!
public class Projektant2 implements Projektant {
        
    @Override
    public EkranskaForma kreirajEkranskuFormu() {
        Panel_a pan = new Panel1_2(); 
        EkranskaForma pc = new EkranskaForma2(); 
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

