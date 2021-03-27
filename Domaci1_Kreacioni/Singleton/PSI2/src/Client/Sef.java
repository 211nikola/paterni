package Client;

import AbstractFactory.*;
import AbstractProductA.*;
import AbstractProductB.*;
import AbstractProductC.*;


class SoftverskiSistemSingleton   // Singleton
{
static Sef.SoftverskiSistem ss;
static boolean jedinstvenoPojavljivanje = false;

static Sef.SoftverskiSistem Instance(EkranskaForma ef1,BrokerBazePodataka bbp1,Kontroler_a kon1)
    {   if (jedinstvenoPojavljivanje == false)
           { ss = new Sef.SoftverskiSistem(ef1,bbp1,kon1);
             jedinstvenoPojavljivanje = true;
           }
        return ss;
    }
}

public class Sef { // Client
Projektant proj; // Abstract Factory   
        
        public static class SoftverskiSistem // Complex Product
                   {  EkranskaForma ef; // AbstractProductA 
                      BrokerBazePodataka bbp; // AbstractProductB 
                      Kontroler_a kon; // AbstractProductC 

                      public SoftverskiSistem(EkranskaForma ef1,BrokerBazePodataka bbp1,Kontroler_a kon1){ef=ef1;bbp=bbp1;kon=kon1;}
                      void prikaziEkranskuFormu(){ef.prikaziEkranskuFormu();}

                   }



Sef (Projektant proj1){proj = proj1; }   
public static void main(String args[])  {  
Sef sef;                    
// ConcreteFactory1
Projektant proj = new Projektant2(); // Promenljivo!!!
sef = new Sef(proj);
sef.Kreiraj();
}

void Kreiraj()     { 
      EkranskaForma ef =proj.kreirajEkranskuFormu();
      BrokerBazePodataka bbp = proj.kreirajBrokerBazePodataka();
      Kontroler_a kon= proj.kreirajKontroler(ef,bbp);
      Sef.SoftverskiSistem ss = SoftverskiSistemSingleton.Instance(ef,bbp,kon);
      System.out.println(ss);
      ss.prikaziEkranskuFormu();
      Sef.SoftverskiSistem ss1 = SoftverskiSistemSingleton.Instance(ef,bbp,kon);
      System.out.println(ss1);
} 


    
}
