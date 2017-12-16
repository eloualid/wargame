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
   public void repartition_ressource(){
        double x,y=0;
        int i,j = 0;
        int seuil = (int) Math.round(Math.min(this.longueur, this.longueur)/3); //le nobre des resources créer dépend de les dimention du terrain
  
        //repartiion des cellules qui contient le pétrole sur le terrain du jeux.
       for(int k=0;k<seuil;k++){
             x = Math.random();
             i = 10+(int) Math.round((this.longueur-20)*x);//eviter le region louer aux QG des deux armées
             y = Math.random();
             j = (int) Math.round((this.largeur-1)*y);
              if(this.maquette[i][j].nature == "v") this.maquette[i][j].nature = "oil";
       }
       //repartition des cellules qui contient de l'or sur le terrain.
       for(int k=0;k<seuil;k++){
             x = Math.random();
             i = 10+(int) Math.round((this.longueur-20)*x);
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
    public void construction_terrain(){
        //------------------------------------------------------------------
       //création des deux quartier général dimention 10 * longueur 
       //-------------------------------------------------------------------
       for (int i=0;i<10;i++){
           for (int j=0;j<largeur;j++){
               this.maquette[i][j].nature = "q1";
           }
       }
       //-------------------------------------------------------------------
       for (int i=(this.longueur-10);i<this.longueur;i++){
           for (int j=0;j<this.largeur;j++){
               this.maquette[i][j].nature = "q2";
           }
       }
       //-------------------------------------------------------------------
       //création des obstacles (Montagnes)----------------------------------
       //-------------------------------------------------------------------
       int nbrobs = 5+(int) Math.round(Math.random()* 20); //On définit un minimum de 5 et max de 25 obstacles.
       for (int i=0;i<nbrobs;i++){
           int l = 10+(int) Math.round(Math.random()* (longueur-20));
           int h = (int) Math.round(Math.random()* largeur);
           this.maquette[l][h].nature = "m";
       } 
   }
   public int getLongueur(){
       return this.longueur;
   }
    public int getLargeur(){
       return this.longueur;
   }
}
