/* KonkretniDekoratorKontroleraB.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 19.11.2017
 */
package ConcreteDecorators;

import AbstractProductA.EkranskaForma;
import Component.Kontroler;
import Decorator.DekoratorKontroler;
import Visitor.Visitor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;

public class KonkretniDekoratorKontroleraB extends DekoratorKontroler{  // ConcretreDecoratorB
    Kontroler konOsnovni;
    public KonkretniDekoratorKontroleraB(Kontroler pred, Kontroler osnovni)
     {super(pred); 
      ef = osnovni.getEkranskaForma();
      Povezi(osnovni);
      konOsnovni = osnovni;
     } 
  
    // Dadaje se novo ponasanje postojecem ponasanju.
     @Override
     public void Povezi(Kontroler kon) { // Kada se aktivira JFrame fokus se prebacuje na polje BrojIndeksa.
                
        ef.addWindowListener( new WindowAdapter() {
                  @Override
                  //public void windowOpened( WindowEvent e ){
                   public void  windowActivated ( WindowEvent e ){
//                  ef.getPanel().getBrojIndeksa1().requestFocus();
                  ef.getPanel().getNadji().setVisible(false);
                  }});
        
   kon.Povezi(this); // Povezivanje konkretnog dekoratora sa osluskivacem.
  }
  
  public Kontroler vratiKonOsnovni() {return konOsnovni;}
      
  @Override
  public void visitorPromeni(Visitor vis)
      {vis.visitKontrolerB(this);}
      
  @Override
  public void visitorKreiraj(Visitor vis)
      {vis.visitKontrolerB(this);}
      
  @Override
  public void visitorNadji(Visitor vis)
      {vis.visitKontrolerB(this);}
      
  @Override
  public void visitorObrisi(Visitor vis)
      {vis.visitKontrolerB(this);}
   
//  public boolean proveraVrOgranicenja(){
//     {    String SifraPredmeta = konOsnovni.getEkranskaForma().getPanel().getSifraPredmeta();
//          if (Broj.daLiJeBroj(SifraPredmeta))   
//               return true;
//           return false;
//     } 
//    
//    
//    } 

}

class Broj  
{ static boolean daLiJeBroj(String broj)
   { try  { int c = Integer.parseInt(broj);
          }  catch(NumberFormatException nfe)  { return false; }
     return true;
   }
}