
 package Receiver;

 import Client.Kontroler_a;

 public class PromeniDomenskiObjekat { // Receiver
    
    Kontroler_a kon;
    
    
    public PromeniDomenskiObjekat(Kontroler_a kon1){kon=kon1;} 
     
    public boolean promeniDomenskiObjekat(){
    kon.napuniDomenskiObjekatIzGrafickogObjekta();
    kon.getBrokerBazePodataka().makeConnection();
    boolean signal = kon.getBrokerBazePodataka().updateRecord(kon.getDomenskiObjekat());
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
