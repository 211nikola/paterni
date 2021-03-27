package Builder;

import AbstractProductA.*;
import AbstractProductC.*;
import Subject.Subject;


public abstract class Projektant {
      class SoftverskiSistem // Complex Product
           {  EkranskaForma ef; // AbstractProductA 
              ConcreteSubject.BrokerBazePodataka bbp; // AbstractProductB 
              Kontroler_a kon; // AbstractProductC 
           }
      
       SoftverskiSistem ss;
               
       abstract public void kreirajEkranskuFormu();   
       abstract public void kreirajBrokerBazePodataka (Subject sub);
       abstract public void kreirajKontroler ();
       abstract public void kreirajSoftverskiSistem();
       abstract public void prikaziEkranskuFormu();
       public Kontroler_a vratiKontroler() {return ss.kon;} 
}
