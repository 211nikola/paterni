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
import Component.Kontroler;
import ConcreteComponent.Kontroler1;
import ConcreteDecorators.KonkretniDekoratorKontroleraA;
import ConcreteDecorators.KonkretniDekoratorKontroleraB;

// Promenljivo!!!
public class Projektant1 implements Projektant {
        
    @Override
    public EkranskaForma kreirajEkranskuFormu() {
        Panel_a pan = new Panel1_1(); 
        EkranskaForma pc = new EkranskaForma2(); 
        pc.setPanel(pan);
        return pc;
    }   
    
    @Override
    public BrokerBazePodataka kreirajBrokerBazePodataka () 
      { BrokerBazePodataka dbbr = new BrokerBazePodataka2(); 
        return dbbr;}  
    
    @Override
    public Kontroler kreirajKontroler (EkranskaForma ef,BrokerBazePodataka dbbr) {
        Kontroler kon = new Kontroler1(ef,dbbr); // Promenljivo!!!
        KonkretniDekoratorKontroleraA kdka = new KonkretniDekoratorKontroleraA(kon);
        KonkretniDekoratorKontroleraB kdkb = new KonkretniDekoratorKontroleraB(kdka,kon); 
                
        return kdkb;
    }
        
   
}

