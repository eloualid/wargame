/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wargame;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author pci
 */
//------------------------------------------------------------------------------------------------------------------------------------
public class Troupe extends Unite{
    private HashSet Soldat;  
   public  Troupe(){
        Soldat = new HashSet();
        for(int i=0;i<14;i++){
            Soldat  s = new Soldat();
            Soldat.add(s);
        }
         this.force = 14*150;
         this.arme = new Arme("D30");
    }
    public void deplacer(String direction){
         Iterator it = this.Soldat.iterator();
         while(it.hasNext()){
           Soldat s= (Soldat)it.next();
              switch(direction){
                case "haut"  : s.deplacer("haut",3); break; //déplacement en haut 
                case "bas"   : s.deplacer("bas",3);  break;   //deplacement en bas 
                case "dbas"  : s.deplacer("dbas",3); break;  //deplacement en bas à droite 
                case "gbas"  : s.deplacer("gbas",3); break;  //deplacement en bas à gauche
                case "ghaut" : s.deplacer("ghaut",3);break; //deplacement en haut à gauche
                case "dhaut" : s.deplacer("dhaut",3);break; // deplacement en haut à droite 
              }
         }
         setposition();
    }
    //------------------------------------------------------tirer---------------------------------------------------------------------
    @Override
    public void tirer(Case c){
        super.tirer(c);
    }
    //------------------------------------ramasser des ressources --------------------------------------------------------------------
    @Override
    public void ramasser(Case c){
        super.ramasser(c);
    }
    //------------------------------------recuperation de la collection des soldats qui forment cette troupe--------------------------
    public HashSet getsoldats(){
        return this.Soldat;
    }
    //---------------------------------------------------------------------------------------------------------------------------------
    public void setsoldats(Soldat s){
        this.Soldat.add(s);
    }
    //----------------------------------------------------------------------------------------------------------------------------------
    public void est_vide(){
        
          if (this.Soldat.isEmpty()){
              System.out.print("soldats epuisées\n");
          }else System.out.print("il y on a encore des soldats\n");
    }
    //-------------------------------------------------------------------------------------
    public void setposition(){
        Iterator it = this.Soldat.iterator();
        int x=0;
        int y=0;
         while(it.hasNext()){
           Soldat s= (Soldat)it.next();
           x+=s.positionx;
           y+=s.positiony;    
         }
         this.positionx = Math.round(x/14);
         this.positiony = Math.round(y/14);
    }
    //------------------------------------------------------------------------------------
   
    
}
