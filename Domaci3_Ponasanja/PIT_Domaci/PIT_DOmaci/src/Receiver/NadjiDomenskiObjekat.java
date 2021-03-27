
package Receiver;


import AbstractProductB.BrokerBazePodataka;
import Client.Kontroler_a;
import DomainClasses.DKPrijavaClanova;

 public class NadjiDomenskiObjekat { // Receiver
    
   BrokerBazePodataka bbp;
    Kontroler_a kon;
    
    
    public NadjiDomenskiObjekat(BrokerBazePodataka bbp1,Kontroler_a kon1){bbp=bbp1;kon=kon1;}
     
    public boolean nadjiDomenskiObjekat(){
    kon.napuniDomenskiObjekatIzGrafickogObjekta();
    boolean signal;
    kon.getBrokerBazePodataka().makeConnection();
    DKPrijavaClanova ip = (DKPrijavaClanova)kon.getBrokerBazePodataka().findRecord(kon.getDomenskiObjekat()); // Promenljivo!!!
    if (ip != null) 
        { kon.napuniGrafickiObjekatIzDomenskogObjekta(ip);
          kon.setPoruka("Систем je нашао испитну пријаву."); // Promenljivo!!!
          signal = true;
        }
        else
        { kon.isprazniGrafickiObjekat();
          kon.setPoruka("Систем не може да нађе испитну пријаву."); // Promenljivo!!!
          signal = false;
        }
    kon.prikaziPoruku();
     bbp.closeConnection();
    return signal;  
}
    
}
