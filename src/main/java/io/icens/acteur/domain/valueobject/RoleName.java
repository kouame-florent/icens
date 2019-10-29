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
public enum RoleName {
    
    ADMINISTRATEUR("Administrateur"),
    OFFICIER_ETAT_CIVIL("Officier état civil"),
    AGENT_ETAT_CIVIL("Agent état civil"),
    CHEF_ETAT_CIVIL("Chef état civil"),
    ARCHIVISTE("Archiviste"),
    REQUERANT("Requérant");
    
    private final String statut;
    
    private RoleName(String statut){
        this.statut = statut;
    }

    public String statut() {
        return statut;
    }
}
