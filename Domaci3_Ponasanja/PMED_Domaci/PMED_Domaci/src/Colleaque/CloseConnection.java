
package Colleaque;

import AbstractProductB.BrokerBazePodataka;
import Client.Kontroler_a;

public class CloseConnection extends Colleague{
   public CloseConnection(BrokerBazePodataka bbp1,Kontroler_a kon1){bbp=bbp1;kon=kon1;}
      
    public void closeConnection()
   {   kon.prikaziPoruku();
       bbp.closeConnection();
   }
   
}
