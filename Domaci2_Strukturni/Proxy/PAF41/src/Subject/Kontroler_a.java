/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Subject;

/**
 *
 * @author Nikola
 */


import AbstractProductA.EkranskaForma;
import AbstractProductB.BrokerBazePodataka;
import DomainClasses.DKPrijavaClanova;

public abstract class Kontroler_a {
   protected EkranskaForma ef;
   protected BrokerBazePodataka bbp;
   protected DKPrijavaClanova pc;   
   protected String poruka;
        
    public void Povezi(Kontroler_a kon) {}
    public abstract boolean zapamtiDomenskiObjekat();
    public abstract boolean kreirajDomenskiObjekat();
    public abstract boolean obrisiDomenskiObjekat();
    public abstract boolean promeniDomenskiObjekat();
    public abstract boolean nadjiDomenskiObjekat();
    public void napuniDomenskiObjekatIzGrafickogObjekta(){}
    public EkranskaForma getEkranskaForma(){return ef;}
    public void setIkonu(String nazivIkone){}
    public void startAudioKlip(String nazivKlipa){} 
}
