
package Receiver;

import AbstractProductB.BrokerBazePodataka;
import Client.Kontroler_a;


public class ObrisiDomenskiObjekat {
    BrokerBazePodataka bbp;
    Kontroler_a kon;
    
    
    public ObrisiDomenskiObjekat(BrokerBazePodataka bbp1,Kontroler_a kon1){bbp=bbp1;kon=kon1;} 
    
    public boolean obrisiDomenskiObjekat(){
     kon.napuniDomenskiObjekatIzGrafickogObjekta();
     kon.getBrokerBazePodataka().makeConnection();
     boolean signal = kon.getBrokerBazePodataka().deleteRecord(kon.getDomenskiObjekat());
     if (signal==true) 
        { kon.getBrokerBazePodataka().commitTransation();
          kon.setPoruka("������ je o������ ������� ������."); // Promenljivo!!!
          kon.isprazniGrafickiObjekat();
        }
     else
        { kon.getBrokerBazePodataka().rollbackTransation();
          kon.setPoruka("������ �� ���� �� ������ ������� ������."); // Promenljivo!!!
        }
     kon.prikaziPoruku();
    kon.getBrokerBazePodataka().closeConnection();
    return signal;   
  }   
}
