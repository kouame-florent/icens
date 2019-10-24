/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.registre.domain.valueobject;

/**
 *
 * @author root
 */
public enum TypeRegistre {
    
    REGISTRE_DE_NAISSANCE("Registre de naissance"),
    REGISTRE_SPECIAL_DE_NAISSANCE("Registre spécial de naissance"),
    REGISTRE_DE_DECES("Registre de deces"),
    REGISTRE_SPECIAL_DE_DECES("Registre spécial de décès"),
    REGISTRE_DE_MARIAGE("Registre de mariage"),
    REGISTRE_SPECIAL_DE_MARIAGE("Registre spécial de mariage"),
    REGISTRE_DES_ACTES_DIVERS("Registre des actes divers"),
    REGISTRE_SPECIAL_DES_ACTES_DIVERS("Registre spécial des actes divers");
    
    private final String libelle;
    
    private TypeRegistre(String libelle){
        this.libelle = libelle;
    }
    
    public String libelle(){
        return libelle;
    }
}
