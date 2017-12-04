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
       maquette = new Case [longueur][largeur];
       float a=0;
       float b=0;
       for (int i=0;i<longueur;i++){
            if(i%2==0)b=1;else b=2; 
           for (int j=0;j<largeur;j++){
               maquette[i][j].x = a;
               maquette[i][j].y = b;
               b+=2;
               }
            a+=1.5;
           }
   }
}
