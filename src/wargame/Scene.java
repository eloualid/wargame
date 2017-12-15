/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wargame;

/**
 *
 * @author pci
 */
public interface Scene {
    Terrain t = new Terrain(100,100); //intialisation du plataeau du jeux 'création des cases' 
    Joueur j1 = new Joueur(1);
    Joueur j2 = new Joueur(2);
    
}
