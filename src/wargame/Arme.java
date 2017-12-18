/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wargame;

import java.util.TreeSet;
/**
 *
 * @author pci
 */
public class Arme {
    private double poids;
    private int portee;
    private int degreinf;
    private String nature;
    private int munition;  
    private String designation ;
    public int cout ;
     //-------------------------------------------------------------------------------------------
    public Arme(String designation){
        if (designation == "Clash"){
                this.designation="Clash";
                this.degreinf= 30;
                this.portee = 9;
                this.munition= 30;
                this.cout = 3000;
                this.poids = 4.5;
                this.nature = "leger";    
        }else if (designation == "Revolver"){
                this.designation="Revolver";
                this.degreinf= 10;
                this.portee = 3;
                this.munition= 10;
                this.cout = 100;
                this.poids = 0.5;
                this.nature = "leger";
                
        }else if (designation == "D30"){
            this.designation="D30";
                this.degreinf= 100;
                this.portee = 20;
                this.munition= 10;
                this.cout = 30000;
                this.poids = 900;
                this.nature = "lourd";
        }
    }
    //-----------------------------------------------------------------
    public double getPoids(){
        return this.poids;
    }
    public void setPoids(double p){
        this.poids = p;
    }
    //-----------------------------------------------------------------
    public int getDegInf(){
        return this.degreinf;
    }
     public void setDegInf(int d){
        this.degreinf= d;
    }
    //------------------------------------------------------------------
    public int getPortee(){
        return this.portee;
    }
    public void setPortee(int porte){
         this.portee = porte;
    }
    //------------------------------------------------------------------
    public String getNature(){
        return this.nature;
    }
     public void setNature(String nature){
         this.nature = nature;
    }
    //------------------------------------------------------------------
    public int getMunition(){
        return this.munition;
    }
    public void setMunition(int munition){
        this.munition = munition;
    }
    //-------------------------------------------------------------------
     public String getDesignation(){
        return this.designation;
    }
    public void setDesignation(String designation){
        this.designation = designation;
    }
    //-------------------------------------------------------------------
    public void afficher(){
            System.out.print("Designation :" + this.designation +"\n");
            System.out.print("Degre d'influence :" +  this.degreinf +"\n");
            System.out.print("Portee :" +  this.portee +"\n");
            System.out.print("Munition :" +  this.munition +"\n");
            System.out.print("Poids:" +  this.poids +"\n");
    }
}
