/* ProxyKontroler.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 06.11.2017
 */

package ConcreteHandler;



import Handler.Kontroler_a;


public class KontrolerVrOg extends Kontroler_a{ // Proxy
       
    public KontrolerVrOg(Kontroler_a kon1,Kontroler_a konOsnovni) {super(kon1,konOsnovni);konOsnovni.Povezi(this);}
          
       
    @Override
    public boolean promeniDomenskiObjekat()
    
    {    String SifraPredmeta = konOsnovni.getEkranskaForma().getPanel().getSifraPrijave();
         if  (Broj.daLiJeBroj(SifraPredmeta))   
               return kon.promeniDomenskiObjekat();
         konOsnovni.prikaziPoruku("‘ормат поЪа Sifra predmeta ниЉе добар!!!");
         konOsnovni.getEkranskaForma().getPanel().setSifrraPrijave("0");
         return false;
    } 
    
    
    } 


class Broj  
{ static boolean daLiJeBroj(String broj)
   { try  { int c = Integer.parseInt(broj);
          }  catch(NumberFormatException nfe)  { return false; }
     return true;
   }
}