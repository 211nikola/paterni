


package Builder;

import AbstractProductA.*;
import AbstractProductB.*;
import AbstractProductC.*;


public class Projektant2 extends Projektant {
       
    @Override
    public void kreirajSoftverskiSistem()
    { ss = new Projektant.SoftverskiSistem();
    }
    
    @Override
    public void kreirajEkranskuFormu() 
      { Panel_a pan = new Panel1_2(); 
        ss.ef = new EkranskaForma1(); 
        ss.ef.setPanel(pan);
      }   
    
    @Override
    public void kreirajBrokerBazePodataka () 
      { ss.bbp = new BrokerBazePodataka1(); 
      }  
        
    @Override
    public void kreirajKontroler () 
      { ss.kon = new Kontroler11(ss.ef,ss.bbp); 
      }

    @Override
    public void prikaziEkranskuFormu() 
      { ss.ef.prikaziEkranskuFormu();
      }
}

