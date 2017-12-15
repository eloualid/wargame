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
public class Soldat implements Actions,Scene{
    private  Arme arme;
    private int force; //le nombre qui represente la santé du soldat
    private int positionx; //indice i de la case occupée par le soldat dans le terrain
    private int positiony; //indice j de la case occupée par le soldat dans le terrain
    public Soldat(){
        force = 150;
    }
    public void deplacer(String direction){
        switch(direction){
            case "haut" : this.positiony +=1;  //déplacement en haut 
            case "bas" : this.positiony -=1;  //deplacement en bas 
            case "dhaut" : this.positionx+=1;  //deplacement en haut à droite 
            case "dbas" : this.positionx-=1;   // deplacement en bas à droite 
            case "ghaut" : {this.positionx-=1; this.positiony+=1;} //deplacement en haut à gauche
            case "gbas" :  { this.positionx+=1; this.positiony+=1;}  //deplacement en haut à gauche
        }
        }
        public void tirer (Case c){
           int d = this.calcul_distance(c);
           int p = this.arme.getPortee();
           if(p >= d ){
               if(Wargame.tour == "j1"){
                   //retour de soldat/troupe ciblé
                   //dimunition de la force
               }
               if(Wargame.tour == "j1"){
                   
               }
               
           }
        }
        public void ramasser (Case c){
            if (c.nature == "n")this.force+=30;
            if (c.nature == "oil")//augmentation du budget du joueur possedant ce soldat
            if (c.nature == "or")this.force+=30;//augmentation du budget du joueur possedant ce soldat
        }
        public int calcul_distance(Case c){
           Case s= t.maquette[this.positionx][this.positiony];
           int  d = (int) Math.sqrt((s.x-c.x)*(s.x-c.x)+(s.y-c.y)*(s.y-c.y)); 
           return d;
        }
}
