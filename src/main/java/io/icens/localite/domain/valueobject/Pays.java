/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.localite.domain.valueobject;

/**
 *
 * @author root
 */
public enum Pays {
    
    COTE_IVOIRE("Côte d'Ivoire","Ivoirienne"),
    BURKINA_FASO("Burkina Faso","Burkinabée");
    
    private final String nom;
    private final String nationnalite;
    
    private Pays(String nom,String nationnalite){
        this.nom = nom;
        this.nationnalite = nationnalite;
    }
    
    public String nom(){
        return nom;
    }

    public String nationnalite() {
        return nationnalite;
    }
}
