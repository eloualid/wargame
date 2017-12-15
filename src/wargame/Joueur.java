/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wargame;

import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author pci
 */
public class Joueur {
    private double budget;
    public int numero;
    private TreeSet soldats;
    private TreeSet troupes;
    
    //-------------------------------
    public Joueur(int n){
        budget = 150000.00;
        numero = n;
    }
    public void setBudget(double montant){
        this.budget += montant;
    }
    public double  getBudget(){
        return this.budget ;
    }
     public void force_selection(){
         System.out.print("JOUEUR N° :"+ this.numero +" VOUS POUVEZ SELECTIONNER VOS FORCES !!");
         System.out.print("Liste des forces disponibles !!");
         System.out.print("1.Soldat cout = 2000 u \n 1 arme léger possible ...\n ");
         System.out.print("1.troupe artillerie contient 15 soldats  cout = 30.000 u \n 1 arme lourd possible ...");
         Scanner sc = new Scanner(System.in);
         int i = 0;
         int q = 0;
         double cout =0;
         while (i!=9){
              System.out.print("entrer le nombre de soldats que vous voulez achetés \n");
              System.out.print("chaque soldat doit avoir au moin une arme que vous allez choisir en suite \n");
              System.out.print("Saisissez 1 pour soldas avec clash \n");
              System.out.print("Saisissez 2 pour soldas avec revolver \n");
              System.out.print("Saisissez 3 pour troupe avec D30 \n");
              System.out.print("Saisissez 9 pour quittez \n");
              i = sc.nextInt(); 
              if (i!= 9){
                   System.out.print("Saisissez la quantité");
                    q = sc.nextInt();
                   if(i==1)  cout = q*(2000 + 3000);                     
                   if(i==2)  cout = q*(2000 + 100);
                   if(i==3)  cout = q*(30000+ 30000);
                   if(cout > this.budget){
                            System.out.print("vous déppassez otre budget \n");
                       }else{
                       this.budget -= cout;
                        if(i==1){
                            //création des objets soldats avec clash
                            for (int k=0;k<q;k++){
                                Soldat s = new Soldat();
                                soldats.add(s);
                            }
                        }
                        if(i==2){
                            //création des objets troupes avec revolver
                        }
                         if(i==3){
                            //création des objets troupes
                        }
                   }
              }
         }
    }
}
