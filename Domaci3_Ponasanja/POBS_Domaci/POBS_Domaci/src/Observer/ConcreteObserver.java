/* ConcreteObserver.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 02.12.2017
 */
package Observer;

import DomainClasses.DKPrijavaClanova;
import AbstractProductC.Kontroler_a;

public class ConcreteObserver implements Observer
{ Kontroler_a kon;
   
  public ConcreteObserver(Kontroler_a kon1) {kon=kon1;}  
  
   @Override
   public void Update(int brojPrijave)
    { DKPrijavaClanova tekucaip = (DKPrijavaClanova) kon.getDKObject();
      if (tekucaip!=null)
              {
                 if (brojPrijave == tekucaip.getSifraPrijave())
                   { kon.nadjiDomenskiObjekat();
                   }     
              }  
    }
   
   
   
}

