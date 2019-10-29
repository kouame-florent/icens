/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.acteur.domain.valueobject;

/**
 *
 * @author root
 */
public enum StatutGroupe {
    
    ENABLED("Enable"),
    DISABLED("Valide");
    
    private final String statut;
    
    private StatutGroupe(String statut){
        this.statut = statut;
    }

    public String statut() {
        return statut;
    }
}
