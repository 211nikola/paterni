
package Originator;

import DomainClasses.DKPrijavaClanova;


public class Originator {
    DKPrijavaClanova dkip;
    
    public void setMemento(DKPrijavaClanova dkip)
    { 
      this.dkip = dkip;
    }
    
    public DKPrijavaClanova createMemento()
    { return new DKPrijavaClanova(this.dkip);}
}
