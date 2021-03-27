/* Obradjen.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 02.12.2017
 */

package ConcreteState;

import AbstractProductC.Kontroler_a;
import DomainClasses.DKPrijavaClanova;
import State.Stanje;

public class Obradjen extends Stanje{ 
    public Obradjen(Kontroler_a kon1) {kon = kon1;}
    @Override
    public void obradiDomenskiObjekat()
     { kon.setPoruka("Не може да се обради обрађена испитна пријава!");
       kon.prikaziPoruku();
       kon.nadjiDomenskiObjekat1();
     }
    @Override
    public void stornirajDomenskiObjekat()
    { DKPrijavaClanova dk = (DKPrijavaClanova) kon.getDKObject();
       dk.setStanje("storniran");
       kon.promeniDomenskiObjekat();
       kon.napuniGrafickiObjekatIzDomenskogObjekta(dk);
    }
    
    @Override
    public void promeniDomenskiObjekat()
     { kon.setPoruka("Не може да се промени обрађена испитна пријава!");
       kon.prikaziPoruku();
       kon.nadjiDomenskiObjekat1();
      
     }
    
}
