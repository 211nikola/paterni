
package Colleaque;

import AbstractProductB.BrokerBazePodataka;
import Client.Kontroler_a;
import DomainClasses.GeneralDObject;
import Mediator.Mediator;

 public class NadjiDomenskiObjekat extends Colleague { 
    
     public NadjiDomenskiObjekat(BrokerBazePodataka bbp1,Kontroler_a kon1,Mediator med1){bbp=bbp1;kon=kon1;med=med1;}
    
    public boolean nadjiDomenskiObjekat(){
    med.makeConnection();
    boolean signal;
    GeneralDObject ip = med.findRecord(); 
    if (ip != null) 
        { med.uspesnaDBOperacija3("������ je ����� ������� ������.",ip); // Promenljivo!!!
          signal = true;
        }
        else
        { med.neuspesnaDBOperacija2("������ �� ���� �� ���� ������� ������."); // Promenljivo!!!
          signal = false;
        }
    med.closeConnection();
    return signal;  
}
    
}
