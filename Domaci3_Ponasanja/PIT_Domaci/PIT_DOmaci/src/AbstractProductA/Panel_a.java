/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractProductA;

import java.util.Date;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Nikola
 */
public abstract class Panel_a extends JPanel{
    
    public abstract String getSifraPrijave();
    public abstract javax.swing.JTextField getSifraPrijave1(); 
    public abstract String getIme();
    public abstract String getPrezime();
    public abstract String getPozicija();
    public abstract Date getDatum();
    
    public abstract void setSifrraPrijave(String sifraPrijave);
    public abstract void setIme(String ime);
    public abstract void setPrezime(String prezime);
    public abstract void setPozicija(String pozicija);
    public abstract void setDatum(Date datum);
    
    public abstract void setPoruka(String poruka);
    
    public abstract javax.swing.JButton getKreiraj(); 
       public abstract javax.swing.JButton getPromeni(); 
       public abstract javax.swing.JButton getObrisi(); 
       public abstract javax.swing.JButton getNadji();
       public abstract javax.swing.JButton getPrvi();
       public abstract javax.swing.JButton getSledeci();
       public abstract javax.swing.JButton getPredhodni();
       public abstract javax.swing.JButton getZadnji();
    
    
}
