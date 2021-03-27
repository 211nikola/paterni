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
import ConcreteSubject.BrokerBazePodataka;
import DomainClasses.DKPrijavaClanova;
import DomainClasses.GeneralDObject;

public abstract class Kontroler_a {
    EkranskaForma ef;
    BrokerBazePodataka bbp;
    DKPrijavaClanova pc;   // Promenljivo!!!
    String poruka;
    public GeneralDObject getDKObject(){return pc;}
    public abstract void napuniDomenskiObjekatIzGrafickogObjekta(); 
    public abstract boolean nadjiDomenskiObjekat();
}
