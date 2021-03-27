/* KonkretniDekoratorKontroleraA.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 19.11.2017
 */
package ConcreteDecorators;

import Component.Kontroler;
import Decorator.DekoratorKontroler;
import Visitor.Visitor;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class KonkretniDekoratorKontroleraA extends DekoratorKontroler{ // ConcretreDecoratorA
  
    // Dadaje se novo stanje postojecim stanjima.
    JLabel loperacija;
    
    public KonkretniDekoratorKontroleraA(Kontroler osnovni)
     {super(osnovni);
      ef = osnovni.getEkranskaForma();
      loperacija = new JLabel("Operacija");
      loperacija.setLocation(0, 0);
      loperacija.setSize(500, 500);
      loperacija.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/neutrinofaci.jpg")));
      ef.getPanel().add(loperacija);
     } 
    
     @Override
     public void setIkonu(String nazivIkone)
     { ImageIcon ii = new javax.swing.ImageIcon(getClass().getResource("/Images/" + nazivIkone));
      
       loperacija.setIcon(ii); 
     }
     
     public void startAudioKlip(String nazivKlipa)
     {  
         
        URL url = getClass().getResource("/AudioClips/" + nazivKlipa);
           
             
        AudioInputStream audioIn;
        try {
            audioIn = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception ex) {System.out.println("Greska:" + ex);
           

     }
    }  
     public void prikaziOsnovnuIkonu() 
     { 
      
       Timer timer = new Timer();
  
       timer.schedule(new TimerTask() {
       @Override
       public void run() {
       setIkonu("AkreditacijaSILAB.jpg");
       }
      }, 5000);
    }
    
  @Override
  public void visitorPromeni(Visitor vis)
      {vis.visitKontrolerA(this);}
      
  @Override
  public void visitorKreiraj(Visitor vis)
      {vis.visitKontrolerA(this);}
      
  @Override
  public void visitorNadji(Visitor vis)
      {vis.visitKontrolerA(this);}
      
  @Override
  public void visitorObrisi(Visitor vis)
      {vis.visitKontrolerA(this);} 
        
}   
        
