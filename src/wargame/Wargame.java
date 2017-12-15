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
       Terrain t = new Terrain(100,100); //intialisation du plataeau du jeux 'création des cases'
       t.afficher_terrain();
         Joueur j1 = new Joueur(1);
         Joueur j2 = new Joueur(2);
       System.out.print("Bienvenue au jeux WARGAME !!");
       System.out.print("VOTRE BUDGET EST DE"+j1.getBudget()+" u");
       System.out.print("VOUS AVEZ LA POSSIBILITE POUR AUGMENTEZ VOTRE BUDGET DURANT LE JEUX");
       //t.construction_terrain(); // installation des obstacles des QG de chaque joueurs, des rivieres ,montagnes ..etc
       //t.repartition_ressource(); // repartition des ressources Or et pétrole sur la plateau du jeux 
       liste_armes(); // Affichage de la liste des armes disponible dans le jeux
       //j1.force_selection();  //selection des forces pour le premier joueur selon budget
       //j2.force_selection();  //selection des forces pour le deuxiéme joueur selon budget
       //commencer_jeux(); //lancement du jeux pour 
    }
   
    public static void commencer_jeux(){
        
    }  
    public static void liste_armes(){ 
         
        Arme arme1 = new Arme("Clash");
        Arme arme2 = new Arme("Revolver");
        Arme arme3 = new Arme("D30");
        
        arme1.afficher();
        arme2.afficher();
        arme3.afficher(); 
        //------------------------------------------------------------------------
         
    }         
}
