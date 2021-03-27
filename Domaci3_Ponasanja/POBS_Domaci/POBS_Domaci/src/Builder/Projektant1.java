

package Builder;

import AbstractProductA.*;
import AbstractProductC.Kontroler11;
import Subject.Subject;

// promenljivo!!!
public class Projektant1 extends Projektant {
    
    @Override
    public void kreirajSoftverskiSistem()
    { ss = new Projektant.SoftverskiSistem();
    }
    
    @Override
    public void kreirajEkranskuFormu() 
      { Panel_a pan = new Panel1_1(); // promenljivo!!!
        ss.ef = new EkranskaForma2(); // promenljivo!!!
        ss.ef.setPanel(pan);
      }   
    
    @Override
    public void kreirajBrokerBazePodataka (Subject sub) 
      { ss.bbp = new ConcreteSubject.BrokerBazePodataka1(sub); // promenljivo!!!
      }  
        
    @Override
    public void kreirajKontroler () 
      { ss.kon = new Kontroler11(ss.ef,ss.bbp); // promenljivo!!!
      }

    @Override
    public void prikaziEkranskuFormu() 
      { ss.ef.prikaziEkranskuFormu();
      }

    
}