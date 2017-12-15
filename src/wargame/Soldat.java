/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wargame;

import java.util.TreeSet;

/**
 *
 * @author pci
 */
public class Soldat implements Actions{
    private  Arme arme;
    private int force;
    private int positionx;
    private int positiony;
    public Soldat(){
        force = 150;
    }
    public void Deplacer(String direction){
        switch(direction){
            case "haut" : this.positiony +=1;  //déplacement en haut 
            case "bas" : this.positiony -=1;  //deplacement en bas 
            case "dhaut" : this.positionx+=1;  //deplacement en haut à droite 
            case "dbas" : this.positionx-=1;   // deplacement en bas à droite 
            case "ghaut" : {this.positionx-=1; this.positiony+=1;} //deplacement en haut à gauche
            case "gbas" :  { this.positionx+=1; this.positiony+=1;}  //deplacement en haut à gauche
        }
        }
        public void tirer (){
        }
        public void ramasser (){
        }
        public void deplacer (){
        }
}
