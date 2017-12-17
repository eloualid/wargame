/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wargame;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author pci
 */
public class Joueur implements Scene {
    private double budget;
    public int numero;
    private HashSet soldats;
    private HashSet troupes;
    
    //-------------------------------------------------------------------------------------------------------------------
    public Joueur(int n){
        budget = 150000.00;
        numero = n;
        soldats = new HashSet();
        troupes = new HashSet();
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
         System.out.print("1.troupe artillerie contient 14 soldats  cout = 30.000 u \n 1 arme lourd possible ...");
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
               System.out.print("Votre budget est de :"+this.budget+" u \n"); 
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
                                Arme a= new Arme("Clash");
                                s.arme=a;
                                soldats.add(s);
                            }
                        }
                        if(i==2){
                            //création des objets troupes avec revolver
                            Soldat s = new Soldat();
                                Arme a= new Arme("Revolver");
                                s.arme=a;
                                soldats.add(s);
                        }
                         if(i==3){
                            //création des objets troupes
                           Troupe troupe = new Troupe();
                           for(int k=0;k<15;k++){
                               Soldat s = new Soldat();
                               troupe.setsoldats(s);
                           }
                              Arme a= new Arme("D30");
                              troupe.arme = a;
                              troupes.add(troupe);
                        }
                   }
              }
         }
    }
     public void jouer(){
         
     }
     //-----------------------------------Recherche d'un soldat positionné dans une case donné ---------------------------------------
     public Soldat getsoldat(Case c){
          Iterator it = this.soldats.iterator();
      while (it.hasNext()){
          Soldat s= (Soldat)it.next();
           if(t.maquette[s.getPositionx()][s.getPositiony()].x == c.x && t.maquette[s.getPositionx()][s.getPositiony()].y == c.y ){
               return s;
           }
      }
         return null;
     }
     //------------------------------------Reeche d'une troupe qui occupe la zone ciblé-----------------------------------------------
      public Troupe getroupe(Case c){
          Iterator it = this.troupes.iterator();
      while (it.hasNext()){
          Troupe troupe = (Troupe)it.next();
          Iterator it2 = troupe.getsoldats().iterator();
          while(it2.hasNext()){
                 Soldat s = (Soldat)it.next();
             if(t.maquette[s.getPositionx()][s.getPositiony()].x == c.x && t.maquette[s.getPositionx()][s.getPositiony()].y == c.y ){
               return troupe;
           } 
          }
      }
         return null;
     }
      //--------------------------------------------Suppression d'un soldat --------------------------------------------------
      public void delete_soldat(Soldat s){
          this.soldats.remove(s);
      }
       //--------------------------------------------Suppression d'une troupe  --------------------------------------------------
      public void delete_troupe(Troupe troupe){
          this.troupes.remove(troupe);
      }
      //---------------------------------------------  Augmentation du budget   ------------------------------------------------
      public void placer_soldats(){
          //initialisation des position des soldats séléctionner par le joueur dans son QG
          //pour joueur N°1
          Iterator it = this.soldats.iterator();
          int  j=t.getLargeur();
          while(it.hasNext()){
              Soldat s = (Soldat)it.next();
              for(int k=0;k<10;k++){
                  s.positionx = k;
                  s.positiony = j;
              }
              j--;
          }
          //pour joueur N°2 
          j=t.getLargeur();
          while(it.hasNext()){
              Soldat s = (Soldat)it.next();
              for(int k=(t.getLongueur()-10);k<t.getLongueur();k++){
                  s.positionx = k;
                  s.positiony = j;
              }
              j--;
          }
      }
       public void placer_troupes(int position){
          //initialisation des position des troupes séléctionner par le joueur dans son QG
          
      }
      public void add_soldat(Soldat s){
           this.soldats.add(s);
      }
      public void test_soldats(){
        
          if (this.soldats.isEmpty()){
              System.out.print("soldats epuisées\n");
          }else System.out.print("il y on a encore des soldats\n");
    }
} 
