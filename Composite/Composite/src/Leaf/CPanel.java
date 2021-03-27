/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leaf;

import AbstractProductA.Panel_a;

/**
 *
 * @author Sinisa
 */
public class CPanel extends List{
 Panel_a pan;
 public CPanel(Panel_a pan1) {pan = pan1;}
 @Override
 public Object getTipKomponente(){return pan.getClass();}
}
