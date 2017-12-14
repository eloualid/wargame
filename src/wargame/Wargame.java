/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wargame;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author pci
 */
public class Wargame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Terrain t = new Terrain(40,40); //intialisation du plataeau du jeux 'création des cases'
       t.afficher_terrain();
         Joueur j1 = new Joueur(1);
         Joueur j2 = new Joueur(2);
       System.out.print("Bienvenue au jeux WARGAME !!");
       System.out.print("VOTRE BUDGET EST DE"+j1.getBudget()+" u");
       System.out.print("VOUS AVEZ LA POSSIBILITE POUR AUGMENTEZ VOTRE BUDGET DURANT LE JEUX");
       t.construction_terrain(); // installation des obstacles des QG de chaque joueurs, des rivieres ,montagnes ..etc
       t.repartition_ressource(); // repartition des ressources Or et pétrole sur la plateau du jeux 
       j1.force_selection();  //selection des forces pour le premier joueur selon budget
       j2.force_selection();  //selection des forces pour le deuxiéme joueur selon budget
       //commencer_jeux(); //lancement du jeux pour 
    }
   
    public static void commencer_jeux(){
        
    }  
    public static void liste_armes(){ 
        TreeSet Arme = new TreeSet();
        Arme arme1 = new Arme();
        Arme arme2 = new Arme();
        Arme arme3 = new Arme();
        //-------------------initialisation -----------------------------
        arme1.setDesignation("Clash");
        arme1.setDegInf(30);
        arme1.setPortee(3);
        arme1.setMunition(30);
        arme1.cout = 3000;
        arme1.setPoids(4.5);
        arme1.setNature("leger");
        Arme.add(arme1);
        //---------------------------------------------------------------
        arme2.setDesignation("Revolver");
        arme2.setDegInf(10);
        arme2.setPortee(1);
        arme2.setMunition(10);
        arme2.cout = 100;
        arme2.setPoids(1.5);
        arme2.setNature("leger");
        Arme.add(arme2);
        //---------------------------------------------------------------
        arme3.setDesignation("D30");
        arme3.setDegInf(100);
        arme3.setPortee(6);
        arme3.setMunition(10);
        arme3.cout = 30000;
        arme3.setPoids(700);
        arme3.setNature("lourd");
        Arme.add(arme3); 
        //------------------------------------------------------------------------
        Iterator it = Arme.iterator();
        System.out.print("Liste des armes disponibles :");
          int i=0;
          while (it.hasNext()){
            System.out.print("Arme n°:" + i +"\n");
            Arme a= (Arme)it.next();
            System.out.print("Designation :" +  a.getDesignation() +"\n");
            System.out.print("Degre d'influence :" +  a.getDegInf() +"\n");
            System.out.print("Portee :" +  a.getPortee() +"\n");
            System.out.print("Munition :" +  a.getMunition() +"\n");
            System.out.print("Poids:" +  a.getPoids() +"\n");
           i++;
      }
    }         
}
