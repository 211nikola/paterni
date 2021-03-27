
package Colleaque;

import AbstractProductB.BrokerBazePodataka;
import Client.Kontroler_a;
import Mediator.Mediator;


 public class KreirajDomenskiObjekat extends Colleague{ 
    
    public KreirajDomenskiObjekat(BrokerBazePodataka bbp1,Kontroler_a kon1,Mediator med1){bbp=bbp1;kon=kon1;med=med1;} 
     
    public boolean kreirajDomenskiObjekat(){
    boolean signal;
    bbp.makeConnection();
    signal = med.insertRecord();
    if (signal==true) 
        { med.uspesnaDBOperacija1("Систем је креирао нову испитну пријаву.",kon.getDomenskiObjekat()); // Promenljivo!!!
        }
        else
        { med.neuspesnaDBOperacija("Систем не може да креира нову испитну пријаву."); // Promenljivo!!!
        }
    med.closeConnection();
    return signal;
}
    
}
