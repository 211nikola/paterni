
package Colleaque;

import AbstractProductB.BrokerBazePodataka;
import Client.Kontroler_a;
import Mediator.Mediator;

 public class ZapamtiDomenskiObjekat extends Colleague { 
      
    public ZapamtiDomenskiObjekat(BrokerBazePodataka bbp1,Kontroler_a kon1,Mediator med1){bbp=bbp1;kon=kon1;med=med1;}
    
    public boolean zapamtiDomenskiObjekat(){
    med.makeConnection();
    boolean signal = med.insertRecord();
    if (signal==true) 
        { med.uspesnaDBOperacija("������ je �������� ������� ������."); // Promenljivo!!!
        }
        else
        { med.neuspesnaDBOperacija("������ �� ���� �� ������� ������� ������."); // Promenljivo!!!
        }
    med.closeConnection();
    return signal;   
}
    
}
