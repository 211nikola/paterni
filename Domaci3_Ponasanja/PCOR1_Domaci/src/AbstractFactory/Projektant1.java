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
import ConcreteHandler.Kontroler22;
import ConcreteHandler.KontrolerStOg;
import ConcreteHandler.KontrolerVrOg;
import Handler.Kontroler_a;

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
       Kontroler22 kon = new Kontroler22(ef,dbbr); // Promenljivo!!!
        KontrolerStOg stog = new KontrolerStOg(kon,kon);
        KontrolerVrOg vrog = new KontrolerVrOg(stog,kon);
        return vrog;
    }
        
   
}

