
package Colleaque;

import AbstractProductB.BrokerBazePodataka;
import Client.Kontroler_a;
import Mediator.Mediator;


public class MakeConnection extends Colleague{
   public MakeConnection(BrokerBazePodataka bbp1,Kontroler_a kon1){bbp=bbp1;kon=kon1;}
      
    public void makeConnection()
   {  kon.napuniDomenskiObjekatIzGrafickogObjekta();
      bbp.makeConnection();
   }
    
   
}
