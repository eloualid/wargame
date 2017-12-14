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
    private Case[][] maquette;
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
       for (int i=0;i< longueur;i++){
           for(int j=0;j<largeur;j++){
               System.out.print("le centre de la case "+i+" "+j+" est :");
               System.out.print(maquette[i][j].x + " " + maquette[i][j].y);
               System.out.print("\n");
           }
       }
       
   }
   
   public void construction_terrain(){
       
   }
   public void repartition_ressource(){
       
   }
   
}
