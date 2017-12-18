/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wargame;

import java.util.Iterator;
import static wargame.Scene.j1;
import static wargame.Scene.j2;
import static wargame.Scene.t;

/**
 *
 * @author pci
 */
public abstract class Unite {
    protected  Arme arme;
    protected int force; //le nombre qui represente la santé du soldat
    protected int positionx; //indice i de la case occupée par le soldat dans le terrain
    protected int positiony; //indice j de la case occupée par le soldat dans le terrain
     //-------------------------------------------------------------------------------------------
   public void deplacer(String direction){
        switch(direction){
                case "haut" :if(this.positiony < (t.getLargeur()-1)) this.positiony +=1;break;  //déplacement en haut 
                case "bas" :if(this.positiony > 0) this.positiony -=1;break;  //deplacement en bas 
                
                case "dbas" : if(this.positionx < (t.getLongueur()-1)){
                     if((this.positionx%2==1)){
                         this.positionx+=1;
                     }else{
                           this.positionx+=1;
                           this.positiony-=1;
                     }
                } break; //deplacement en bas à droite 
                case "gbas" : if(this.positionx > 0){
                    if((this.positionx%2==1)){
                         this.positionx-=1;
                     }else{
                           this.positionx-=1;
                           this.positiony-=1;
                     }
                 break; } //deplacement en bas à gauche
                case "ghaut" :if((this.positionx > 0)&&(this.positiony < (t.getLargeur()-1))) {
                     if((this.positionx%2==1)){
                         this.positionx-=1;
                         this.positiony+=1;
                     }else{
                           this.positionx-=1;
                     }
                    break;}
                //deplacement en haut à gauche
                case "dhaut" : if((this.positionx < (t.getLongueur()-1))&&(this.positiony < (t.getLargeur()-1))) 
                { 
                    if((this.positionx%2==1)){
                         this.positionx+=1;
                         this.positiony+=1;
                     }else{
                           this.positionx+=1;
                     }
                  break;} // deplacement en haut à droite 
            if(Wargame.tour == "j1"){
                 if (t.maquette[this.positionx][this.positiony].nature == "q2") Wargame.quitter=true;//jeux teminé
            }
            if(Wargame.tour == "j2"){
                 if (t.maquette[this.positionx][this.positiony].nature == "q1") Wargame.quitter=true;//jeux terminé
            }
        }
        }
    //----------------------------------------------------------------------------------------------------------------
        public void tirer (Case c){
           int d = this.calcul_distance(c);
            
           int p = this.arme.getPortee();
           
           Soldat s = null;
           Troupe troupe=null;
           if(p >= d ){
               if(Wargame.tour == "j1"){
                   //retour de "soldat/troupe" du deuxiéme joueur ciblé puis dimunition de sa force
                   s = j2.getunite(c);
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
                    s = j1.getunite(c);
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
         //-------------------------------------------------------------------------------------------
        public void ramasser (Case c){
            int d = this.calcul_distance(c);
            if(d>=0 && d<=2){
                //augmentation de la force du soldat
            if (c.nature == "n"){this.force+=30; c.nature="v";}
            //augmentation du budget du joueur possedant le soldat
            if (c.nature == "oil"){
                if(Wargame.tour == "j1"){
                    j1.setBudget(1000);
                }
                 if(Wargame.tour == "j2"){
                    j2.setBudget(1000);
                }
                 c.nature="v";
            }
            if (c.nature == "or"){
                if(Wargame.tour == "j1"){
                    j1.setBudget(1500);
                }
                 if(Wargame.tour == "j2"){
                    j2.setBudget(1500);
                }
                  c.nature="v";
            }
            }
        }
         //-------------------------------------------------------------------------------------------
         public int calcul_distance(Case c){
           Case s= t.maquette[this.positionx][this.positiony];
           int  d = (int) Math.sqrt((s.x-c.x)*(s.x-c.x)+(s.y-c.y)*(s.y-c.y)); 
           return d;
        }
          //-------------------------------------------------------------------------------------------
        public int getPositionx(){
            return this.positionx;
        }
         //-------------------------------------------------------------------------------------------
        public int getPositiony(){
            return this.positiony;
        }
         //-------------------------------------------------------------------------------------------
        public void Afficher_unite(){
         System.out.print("votre force est : "+ force+"\n");
         System.out.print("votre position x est  : "+ positionx+"\n");
         System.out.print("votre position y est : "+ positiony+"\n");
        }
         //-------------------------------------------------------------------------------------------
         public void deplacer(String direction,int vitesse){
        switch(direction){
                case "haut" :if(this.positiony < (t.getLargeur()-1)) this.positiony +=vitesse;break;  //déplacement en haut 
                case "bas" :if(this.positiony > 0) this.positiony -= vitesse;break;  //deplacement en bas 
                
                case "dbas" : if(this.positionx < (t.getLongueur()-1)){
                     if((this.positionx%2==1)){
                         this.positionx+=vitesse;
                     }else{
                           this.positionx+=vitesse;
                           this.positiony-=vitesse;
                     }
                } break; //deplacement en bas à droite 
                case "gbas" : if(this.positionx > 0){
                    if((this.positionx%2==1)){
                         this.positionx-=1;
                     }else{
                           this.positionx-=vitesse;
                           this.positiony-=vitesse;
                     }
                 break; } //deplacement en bas à gauche
                case "ghaut" :if((this.positionx > 0)&&(this.positiony < (t.getLargeur()-1))) {
                     if((this.positionx%2==1)){
                         this.positionx-=vitesse;
                         this.positiony+=vitesse;
                     }else{
                           this.positionx-=vitesse;
                     }
                    break;}
                //deplacement en haut à gauche
                case "dhaut" : if((this.positionx < (t.getLongueur()-1))&&(this.positiony < (t.getLargeur()-1))) 
                { 
                    if((this.positionx%2==1)){
                         this.positionx+=vitesse;
                         this.positiony+=vitesse;
                     }else{
                           this.positionx+=vitesse;
                     }
                  break;} // deplacement en haut à droite 
            if(Wargame.tour == "j1"){
                 if (t.maquette[this.positionx][this.positiony].nature == "q2") Wargame.quitter=true;//jeux teminé
            }
            if(Wargame.tour == "j2"){
                 if (t.maquette[this.positionx][this.positiony].nature == "q1") Wargame.quitter=true;//jeux terminé
            }
        }
        }
          //-------------------------------------------------------------------------------------------
}
