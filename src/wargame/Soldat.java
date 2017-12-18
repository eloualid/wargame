/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wargame;

import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author pci
 */
public class Soldat extends Unite implements Actions,Scene{
   
    public Soldat(){
        force = 150;
    }
    public Soldat(int x,int y){
        force = 150;
        positionx = x;
        positiony = y;
    }
       public void deplacer(String direction){
         super.deplacer(direction);
    }
    //------------------------------------------------------tirer---------------------------------------------------------------------
    @Override
    public void tirer(Case c){
        super.tirer(c);
    }
    //------------------------------------ramasser des ressources --------------------------------------------------------------------
    @Override
    public void ramasser(Case c){
        super.ramasser(c);
    } 
}
