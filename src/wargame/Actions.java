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
public interface Actions {
    public void deplacer(String direction);
    public void tirer(Case c);
    public void ramasser(Case c);
    public int calcul_distance(Case c);
    
}
