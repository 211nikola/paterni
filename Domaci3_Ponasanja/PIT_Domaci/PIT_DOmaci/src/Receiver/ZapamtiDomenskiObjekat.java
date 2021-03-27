
package Receiver;

import AbstractProductB.BrokerBazePodataka;
import Client.Kontroler_a;

 public class ZapamtiDomenskiObjekat { // Receiver
    
    BrokerBazePodataka bbp;
    Kontroler_a kon;
    
    
    public ZapamtiDomenskiObjekat(BrokerBazePodataka bbp1,Kontroler_a kon1){bbp=bbp1;kon=kon1;}  
     
    public boolean zapamtiDomenskiObjekat(){
    kon.napuniDomenskiObjekatIzGrafickogObjekta();
    kon.getBrokerBazePodataka().makeConnection();
    boolean signal = kon.getBrokerBazePodataka().insertRecord(kon.getDomenskiObjekat());
    if (signal==true) 
        { kon.getBrokerBazePodataka().commitTransation();
          kon.setPoruka("������ je �������� ������� ������."); // Promenljivo!!!
        }
        else
        { kon.getBrokerBazePodataka().rollbackTransation();
          kon.isprazniGrafickiObjekat();
          kon.setPoruka("������ �� ���� �� ������� ������� ������."); // Promenljivo!!!
        }
    kon.prikaziPoruku();
    kon.getBrokerBazePodataka().closeConnection();
    return signal;   
}
    
}
