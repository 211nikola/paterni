/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

/**
 *
 * @author Nikola
 */


import AbstractProductA.EkranskaForma;
import AbstractProductB.BrokerBazePodataka;
import DomainClasses.DKPrijavaClanova;
import DomainClasses.GeneralDObject;
import Iterator.Iterator;

public abstract class Kontroler_a {
    protected EkranskaForma ef;
    protected BrokerBazePodataka bbp;
    DKPrijavaClanova pc;   // Promenljivo!!!
    String poruka;
    Iterator it;
    
    public void napuniGrafickiObjekatIzDomenskogObjekta(GeneralDObject gdo) {}
    public void napuniDomenskiObjekatIzGrafickogObjekta() {}
    public void isprazniGrafickiObjekat(){}
    public void setPoruka(String poruka1){poruka=poruka1;}
    public void prikaziPoruku(){}
    public void prikaziPoruku(String s){}
    public  EkranskaForma getEkranskaForma(){return ef;}
    public BrokerBazePodataka getBrokerBazePodataka(){return bbp;}
    public GeneralDObject getDomenskiObjekat(){return pc;}
    public void iteratorPostaviNaZadnji(){it.last();}
         
}