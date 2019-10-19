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
public enum StatutRegistre {
    
    PROJET("Projet"),
    VALIDE("Validé"),
    ANNULE("Annulé");
    
    private final String statut;
    
    private StatutRegistre(String statut){
        this.statut = statut;
    }

    public String getStatut() {
        return statut;
    }
    
   
}
