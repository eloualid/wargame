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
    protected  Arme arme;
    protected int force; //le nombre qui represente la santé du soldat
    protected int positionx; //indice i de la case occupée par le soldat dans le terrain
    protected int positiony; //indice j de la case occupée par le soldat dans le terrain
    public Soldat(){
        force = 150;
    }
    public void deplacer(String direction){
        switch(direction){
            case "haut" : this.positiony +=1;  //déplacement en haut 
            case "bas" : this.positiony -=1;  //deplacement en bas 
            case "dbas" : this.positionx+=1;  //deplacement en haut à droite 
            case "gbas" : this.positionx-=1;   //deplacement en bas à gauche
            case "ghaut" : {this.positionx-=1; this.positiony+=1;} //deplacement en haut à gauche
            case "dhaut" :  { this.positionx+=1; this.positiony+=1;}  // deplacement en haut à droite 
            if(Wargame.tour == "j1"){
                 if (t.maquette[this.positionx][this.positiony].nature == "q2") Wargame.quitter=true;
            }
            if(Wargame.tour == "j2"){
                 if (t.maquette[this.positionx][this.positiony].nature == "q1") Wargame.quitter=true;
            }
        }
        }
        public void tirer (Case c){
           int d = this.calcul_distance(c);
           int p = this.arme.getPortee();
           Soldat s = null;
           Troupe troupe=null;
           if(p >= d ){
               if(Wargame.tour == "j1"){
                   //retour de "soldat/troupe" ciblé puis dimunition de sa force
                   s = j2.getsoldat(c);
                   if(s!=null){
                        s.force-=this.arme.getDegInf();
                        if( s.force <= 0 ) j2.delete_soldat(s);
                   }else {
                        troupe = j2.getroupe(c);
                        if(troupe !=null){
                            troupe.force-=this.arme.getDegInf();
                            if( troupe.force <= 0 ) j2.delete_troupe(troupe);
                        }
                   }
               }
               if(Wargame.tour == "j2"){
                    s = j1.getsoldat(c);
                   if(s!=null){
                        s.force-=this.arme.getDegInf();
                        if( s.force <= 0 ) j1.delete_soldat(s);
                   }else {
                        troupe = j1.getroupe(c);
                        if(troupe !=null){
                            troupe.force-=this.arme.getDegInf();
                              if( troupe.force <= 0 ) j1.delete_troupe(troupe);
                        }
                   }
               }
           }
        }
        public void ramasser (Case c){
             //augmentation de la force du soldat
            if (c.nature == "n")this.force+=30;
            //augmentation du budget du joueur possedant le soldat
            if (c.nature == "oil"){
                if(Wargame.tour == "j1"){
                    j1.setBudget(1000);
                }
                 if(Wargame.tour == "j2"){
                    j2.setBudget(1000);
                }
            }
            if (c.nature == "or"){
                if(Wargame.tour == "j1"){
                    j1.setBudget(1500);
                }
                 if(Wargame.tour == "j2"){
                    j2.setBudget(1500);
                }
            }
        }
        public int calcul_distance(Case c){
           Case s= t.maquette[this.positionx][this.positiony];
           int  d = (int) Math.sqrt((s.x-c.x)*(s.x-c.x)+(s.y-c.y)*(s.y-c.y)); 
           return d;
        }
        public int getPositionx(){
            return this.positionx;
        }
         public int getPositiony(){
            return this.positiony;
        }
       
}
