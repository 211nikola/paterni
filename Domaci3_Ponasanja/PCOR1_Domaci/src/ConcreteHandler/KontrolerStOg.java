/* ProxyKontroler.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 06.11.2017
 */

package ConcreteHandler;



import DomainClasses.DKPrijavaClanova;
import Handler.Kontroler_a;


public class KontrolerStOg extends Kontroler_a{ // Proxy
       
    
    
    public KontrolerStOg(Kontroler_a kon1,Kontroler_a konOsnovni) {super(kon1,konOsnovni);}
          
    @Override
    public boolean promeniDomenskiObjekat()
    
      {
         if (nadjiPredmet()) 
             return kon.promeniDomenskiObjekat();
         else
             return false;
      } 
    
    public boolean nadjiPredmet(){
    boolean signal;
    konOsnovni.getBrokerBazePodataka().makeConnection();
    DKPrijavaClanova pr = new DKPrijavaClanova();
    int sifraPrijave = Integer.parseInt(konOsnovni.getEkranskaForma().getPanel().getSifraPrijave());
    pr.setSifraPrijave(sifraPrijave);
    
    pr = (DKPrijavaClanova)konOsnovni.getBrokerBazePodataka().findRecord(pr); // Promenljivo!!!
    if (pr != null) 
        { poruka = "Систем je нашао предмет.";  // Promenljivo!!!
          signal = true;
        }
        else
        { poruka ="Систем није нашао предмет!!!"; // Promenljivo!!!
          signal = false;
        }
    konOsnovni.prikaziPoruku(poruka);
    konOsnovni.getBrokerBazePodataka().closeConnection();
    return signal;   
   
    }
}