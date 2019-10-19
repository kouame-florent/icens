/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.registre.domain.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    LocalDateTime dateSortie;
    
    @Getter @Setter
    @Column(name = "date_retour")
    LocalDateTime dateRetour;
    
    @Getter @Setter
    @Column(name = "objet")
    @NotBlank
    @Size(min = 0, max = 500)
    String objet;
    
    @Getter @Setter
    @Column(name = "observation")
    @NotBlank
    @Size(min = 0, max = 1000)
    String observation;
    
    @Getter @Setter
    @Column(name = "agent_uuid")
    @NotBlank
    String agentUuid;
    
    @Getter @Setter
    @NotNull
    @JoinColumn(name = "registre_uuid")
    @ManyToOne
    Registre registre;
}
