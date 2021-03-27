

package Builder;

import Client.Kontroler11;
import AbstractProductA.*;
import AbstractProductB.*;

// promenljivo!!!
public class Projektant1 extends Projektant {
    
    @Override
    public void kreirajSoftverskiSistem()
    { ss = new Projektant.SoftverskiSistem();
    }
    
    @Override
    public void kreirajEkranskuFormu() 
      { Panel_a pan = new Panel1_1(); // promenljivo!!!
        ss.ef = new EkranskaForma1(); // promenljivo!!!
        ss.ef.setPanel(pan);
      }   
    
    @Override
    public void kreirajBrokerBazePodataka () 
      { ss.bbp = new BrokerBazePodataka1(); // promenljivo!!!
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

