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
public enum EtatMouvementRegistre {
    SORTIE("Sortie"),
    RETOUR("Registre spécial de naissance");
    
    private final String etat;
    
    private EtatMouvementRegistre(String etat){
        this.etat = etat;
    }
    
    public String etat(){
        return etat;
    }
}
