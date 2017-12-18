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
public class Wargame implements Scene{

    /**
     * @param args the command line arguments
     */
    public static String tour = "j1";
    public static boolean quitter = false;
    public static void main(String[] args) {
        // TODO code application logic here
       
     // Terrain t = new Terrain(100,100); //intialisation du plataeau du jeux 'création des cases'
      
       System.out.print("Bienvenue au jeux WARGAME !!");
       System.out.print("VOS BUDGETS EST DE"+j1.getBudget()+" u");
       System.out.print("VOUS AVEZ LA POSSIBILITE POUR AUGMENTEZ VOTRE BUDGET DURANT LE JEUX");
       t.construction_terrain(); // installation des obstacles des QG de chaque joueurs, des rivieres ,montagnes ..etc
       t.repartition_ressource(); // repartition des ressources Or et pétrole sur la plateau du jeux 
       //liste_armes(); // Affichage de la liste des armes disponible dans le jeux
       t.afficher_terrain();
      //test_deplacement(); test de déplacement des soldats 
       //test_combat();
       test_recup_ressource();
       //j1.force_selection();  //selection des forces pour le premier joueur selon budget
       //j2.force_selection();  //selection des forces pour le deuxiéme joueur selon budget
      // j1.placer_soldats();
       //j2.placer_soldats();
      /*  while(quitter != true){
           j1.jouer(); //tour du joueur N°1
           switch_tour(); //echange de tour entre joueur
           j2.jouer(); //tour du joueur N°2
       }*/
       //commencer_jeux(); //lancement du jeux pour 
    }
   
    public static void test_deplacement(){  
        Soldat s = new Soldat(30,41);
        //-------------------------------------------------
        s.deplacer("haut");
        s.Afficher_unite();
        //-------------------------------------------------
        s.deplacer("bas");
        s.Afficher_unite();
        //-------------------------------------------------
        s.deplacer("dhaut");
         s.Afficher_unite();
        //-------------------------------------------------
        s.deplacer("gbas");
         s.Afficher_unite();
        //-------------------------------------------------
        s.deplacer("dbas");
         s.Afficher_unite();
        //-------------------------------------------------
        s.deplacer("ghaut");
        s.Afficher_unite();
        //-------------------------------------------------
    }
    public static void test_combat(){  
           Soldat s = new Soldat(30,41); // création des soldats 
            Soldat s2 = new Soldat(32,41); //monter l'effet de la portee et l'efficacité entre les armes proposés.
           //Soldat s2 = new Soldat(35,41);
           Arme a1 = new Arme("Clash"); //création des armes 
           Arme a2 = new Arme("Revolver");
          
           s.arme = a1; //armement des soldats 
           s2.arme = a2;
           j1.add_soldat(s);
           j2.add_soldat(s2);
          
           Case c = t.maquette[s2.positionx][s2.positiony]; 
           Case c2 = t.maquette[s.positionx][s.positiony];
           System.out.print("force du deuxiéme soldat avant tir "+s2.force+"\n");
           s.tirer(c);
          
           System.out.print("force du deuxiéme soldat apres tir "+s2.force+"\n");
           System.out.print("force du premier soldat avant tir "+s.force+"\n");
           tour = "j2";
           s2.tirer(c2);
           System.out.print("force du premier soldat apres tir "+s.force+"\n");
           tour = "j1";
           //simulation de la mort d'un soldat
             s.tirer(c);
             s.tirer(c);
             s.tirer(c);
             System.out.print("force du deuxiéme soldat apres tir "+s2.force+"\n");
             s.tirer(c);
             s.tirer(c);
             s.tirer(c);
             System.out.print("force du deuxiéme soldat apres tir "+s2.force+"\n");
             s.tirer(c);
             j2.est_vide();
             
    }
    public static void test_recup_ressource(){  //test de la recuperation d'une ressource
            Soldat s = new Soldat(30,41); // création des soldats 
            tour = "j1";
            t.maquette[34][45].nature="or";
            Case c = t.maquette[34][45];
            s.deplacer("dhaut");
            s.Afficher_unite();
            s.deplacer("dhaut");
            s.Afficher_unite();
            s.deplacer("dhaut");
             s.Afficher_unite();
            s.deplacer("dhaut");
             s.Afficher_unite();
            s.deplacer("haut");
            s.Afficher_unite();
            s.deplacer("haut");
             s.Afficher_unite();
            s.ramasser(c);
            System.out.print(j1.getBudget()+"\n");
            System.out.print(t.maquette[34][45].nature);
    }
    public static void liste_armes(){ 
         //initialisation 
        Arme arme1 = new Arme("Clash");
        Arme arme2 = new Arme("Revolver");
        Arme arme3 = new Arme("D30");
        //affichage 
        arme1.afficher();
        arme2.afficher();
        arme3.afficher(); 
        //------------------------------------------------------------------------   
    }  
    public static void switch_tour(){
        if (tour=="j1") tour ="j2";else tour="j1"; //échanger le tour entre les deux joueur en alternance
    }
}
