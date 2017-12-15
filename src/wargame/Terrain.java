/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wargame;

import java.lang.reflect.Array;
import java.util.TreeSet;

/**
 *
 * @author pci
 */
public class Terrain {
    private int longueur;
    private int largeur;
    public Case[][] maquette;
   public  Terrain(int x,int y){
       longueur = (x*2)/3;
       largeur = y/2;
       System.out.print(longueur +" "+largeur);
       maquette = new Case [longueur][largeur];
       float a=0;
       float b=0;
       for (int i=0;i<longueur;i++){
            if(i%2==0)b=1;else b=2; 
           for (int j=0;j<largeur;j++){
               Case cas = new Case();
               cas.x = a;
               cas.y = b;
               cas.nature = "v";
               maquette[i][j] = cas;
               b+=2;
               }
            a+=1.5;
           }
   }
   public void afficher_terrain(){
       //Méthode pour afficher le terrain.
       for (int i=0;i< longueur;i++){
           for(int j=0;j<largeur;j++){
               System.out.print("le centre de la case "+i+" "+j+" est :");
               System.out.print(maquette[i][j].x + " " + maquette[i][j].y);
               System.out.print("\n");
               System.out.print("natures :"+maquette[i][j].nature+" ");
               
           }
       }
       
   }
   
   public void construction_terrain(){
       
   }
   public void repartition_ressource(){
        double x,y=0;
        int i,j = 0;
        int seuil = (int) Math.round(Math.min(this.longueur, this.longueur)/3); //le nobre des resources créer dépend de les dimention du terrain
  
        //repartiion des cellules qui contient le pétrole sur le terrain du jeux.
       for(int k=0;k<seuil;k++){
             x = Math.random();
             i = (int) Math.round((this.longueur-1)*x);
             y = Math.random();
             j = (int) Math.round((this.largeur-1)*y);
              if(this.maquette[i][j].nature == "v") this.maquette[i][j].nature = "oil";
       }
       //repartition des cellules qui contient de l'or sur le terrain.
       for(int k=0;k<seuil;k++){
             x = Math.random();
             i = (int) Math.round((this.longueur-1)*x);
             y = Math.random();
             j = (int) Math.round((this.largeur-1)*y);
            if(this.maquette[i][j].nature == "v") this.maquette[i][j].nature = "or";
       }
       //repartition des cellules qui contient la nourriture pour les soldats
       for(int k=0;k<seuil;k++){
             x = Math.random();
             i = (int) Math.round((this.longueur-1)*x);
             y = Math.random();
             j = (int) Math.round((this.largeur-1)*y);
            if(this.maquette[i][j].nature == "v") this.maquette[i][j].nature = "n";
       }
       
   }
   
}
