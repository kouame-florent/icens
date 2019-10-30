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
public enum TypeLocalite {
    
    REGION("Region"),
    DEPARTEMENT("Département"),
    COMMUNE("Commune"),
    SOUS_PRFECTURE("Sous-préfecture"),
    VILLAGE("Village");
    
    private final String type;
    
    private TypeLocalite(String type){
        this.type = type;
    }
    
    public String type(){
        return type;
    }
    
}
