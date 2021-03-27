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
import Proxy.ProxyKontroler;
import RealSubject.Kontroler22;
import Subject.Kontroler_a;

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
        ProxyKontroler pk = new ProxyKontroler(kon);
        return pk;

    }
        
   
}

