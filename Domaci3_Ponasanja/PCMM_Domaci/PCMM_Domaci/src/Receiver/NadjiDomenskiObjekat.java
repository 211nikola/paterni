
package Receiver;


import Client.Kontroler_a;
import DomainClasses.DKPrijavaClanova;

 public class NadjiDomenskiObjekat { // Receiver
    
   Kontroler_a kon;
    
    
    public NadjiDomenskiObjekat(Kontroler_a kon1){kon=kon1;} 
     
    public boolean nadjiDomenskiObjekat(){
    kon.napuniDomenskiObjekatIzGrafickogObjekta();
    boolean signal;
    kon.getBrokerBazePodataka().makeConnection();
    DKPrijavaClanova ip = (DKPrijavaClanova)kon.getBrokerBazePodataka().findRecord(kon.getDomenskiObjekat()); // Promenljivo!!!
    if (ip != null) 
        { kon.napuniGrafickiObjekatIzDomenskogObjekta(ip);
          kon.setPoruka("������ je ����� ������� ������."); // Promenljivo!!!
          signal = true;
        }
        else
        { kon.isprazniGrafickiObjekat();
          kon.setPoruka("������ �� ���� �� ���� ������� ������."); // Promenljivo!!!
          signal = false;
        }
    kon.prikaziPoruku();
    kon.getBrokerBazePodataka().closeConnection();
    return signal;  
}
    
}
