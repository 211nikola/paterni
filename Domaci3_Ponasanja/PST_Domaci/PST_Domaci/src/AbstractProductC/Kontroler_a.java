/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Nikola
 */


package AbstractProductC;

import AbstractProductA.EkranskaForma;
import AbstractProductB.BrokerBazePodataka;
import DomainClasses.DKPrijavaClanova;
import DomainClasses.GeneralDObject;

public abstract class Kontroler_a {
    EkranskaForma ef;
    BrokerBazePodataka bbp;
    DKPrijavaClanova pc;   // Promenljivo!!!
    String poruka;
    public GeneralDObject getDKObject(){return pc;}
    public abstract boolean promeniDomenskiObjekat();
    public void setPoruka(String poruka1){poruka = poruka1;}
    public abstract void prikaziPoruku(); 
    abstract public void napuniGrafickiObjekatIzDomenskogObjekta(DKPrijavaClanova pc);
    abstract public boolean nadjiDomenskiObjekat1();
}
