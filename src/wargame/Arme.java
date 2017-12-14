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
    private double Poids;
    private int Portee;
    private int degreinf;
    private String Nature;
    private int Munition;  
    private String designation ;
    public int cout ;
    
    //-----------------------------------------------------------------
    public double getPoids(){
        return this.Poids;
    }
    public void setPoids(double p){
        this.Poids = p;
    }
    //-----------------------------------------------------------------
    public int getDegInf(){
        return this.degreinf;
    }
     public void setDegInf(int d){
        this.Poids = d;
    }
    //------------------------------------------------------------------
    public int getPortee(){
        return this.Portee;
    }
    public void setPortee(int porte){
         this.Portee = porte;
    }
    //------------------------------------------------------------------
    public String getNature(){
        return this.Nature;
    }
     public void setNature(String nature){
         this.Nature = nature;
    }
    //------------------------------------------------------------------
    public int getMunition(){
        return this.Munition;
    }
    public void setMunition(int munition){
        this.Munition = munition;
    }
    //-------------------------------------------------------------------
     public String getDesignation(){
        return this.designation;
    }
    public void setDesignation(String designation){
        this.designation = designation;
    }
    
}
