/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Target;

import Adaptee.Projektant;


public abstract class Prevodilac { // Target
    protected Projektant pr;
    public Prevodilac(Projektant pr1) {pr = pr1;}
    public abstract void createScreenForm();   
    public abstract void createDatabaseBroker();
    public abstract void createController ();
    public abstract void createSoftwareSystem();
    public abstract void showScreenForm();
}
