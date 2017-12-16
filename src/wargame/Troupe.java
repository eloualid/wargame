/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wargame;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author pci
 */
//------------------------------------------------------------------------------------------------------------------------------------
public class Troupe extends Soldat{
    private HashSet Soldat;  
    Troupe(){
        Soldat = new HashSet();
    }
    public void deplacer(String direction){
         Iterator it = this.Soldat.iterator();
         while(it.hasNext()){
           Soldat s= (Soldat)it.next();
              switch(direction){
                case "haut" : this.positiony +=1;  //déplacement en haut 
                case "bas" : this.positiony -=1;  //deplacement en bas 
                case "dbas" : this.positionx+=1;  //deplacement en haut à droite 
                case "gbas" : this.positionx-=1;   //deplacement en bas à gauche
                case "ghaut" : {this.positionx-=1; this.positiony+=1;} //deplacement en haut à gauche
                case "dhaut" :  { this.positionx+=1; this.positiony+=1;}  // deplacement en haut à droite 
                if(Wargame.tour == "j1"){
                     if (t.maquette[s.positionx][s.positiony].nature == "q2") Wargame.quitter=true;
                }
                if(Wargame.tour == "j2"){
                     if (t.maquette[s.positionx][s.positiony].nature == "q1") Wargame.quitter=true;
                }
              }
         }
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
    //------------------------------------recuperation de la collection des soldats qui forment cette troupe--------------------------
    public HashSet getsoldats(){
        return this.Soldat;
    }
    //---------------------------------------------------------------------------------------------------------------------------------
    public void setsoldats(Soldat s){
        this.Soldat.add(s);
    }
    //----------------------------------------------------------------------------------------------------------------------------------
}
