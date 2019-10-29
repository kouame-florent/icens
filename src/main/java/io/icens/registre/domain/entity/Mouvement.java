/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.registre.domain.entity;

import io.icens.registre.domain.valueobject.EtatMouvementRegistre;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author root
 */
@Table(name = "IC_MOUVEMENT")
@Entity
public class Mouvement extends BaseEntity{
    
    @NotNull @Getter @Setter
    @Column(name = "date_sortie")
    private LocalDateTime dateSortie;
    
    @Getter @Setter
    @Column(name = "date_retour")
    private LocalDateTime dateRetour;
    
    @Getter @Setter
    @Column(name = "etat_mouvement_registre")
    @Enumerated(EnumType.STRING)
    private EtatMouvementRegistre etatMouvementRegistre;
    
    @Getter @Setter
    @Column(name = "objet")
    @NotBlank
    @Size(min = 0, max = 500)
    private String objet;
    
    @Getter @Setter
    @Column(name = "observation")
    @Size(min = 0, max = 1000)
    private String observation;
    
    @Getter @Setter
    @Column(name = "agent_uuid")
    @NotBlank
    private String agentUuid;
    
    @Getter @Setter
    @NotNull
    @JoinColumn(name = "registre_uuid")
    @ManyToOne
    private Registre registre;

    public Mouvement() {
    }

    public Mouvement(String agentUuid, Registre registre,EtatMouvementRegistre etatMouvementRegistre) {
        this.etatMouvementRegistre = etatMouvementRegistre;
        this.agentUuid = agentUuid;
        this.registre = registre;
    }
    
    
}
