/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.acteur.domain.entity;

import io.icens.acteur.domain.valueobject.StatutGroupe;
import io.icens.acteur.domain.valueobject.RoleName;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author root
 */
@Table(name = "IC_GROUPE",
        uniqueConstraints = @UniqueConstraint(name = "UNQ_UTILISATEUR_ROLE_NAME",
                columnNames = {"utilisateur","role_name"})
)
@Entity
public class Groupe extends BaseEntity{
    
    @Getter @Setter
    @Column(name = "utilisateur")
    @ManyToOne
    private Utilisateur utilisateur;
    
    @Getter @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "role_name")
    private RoleName roleName;
    
    @Column(name = "statut_groupe")
    @Enumerated(EnumType.STRING)
    StatutGroupe statutGroupe;

    public Groupe() {
    }

    public Groupe(Utilisateur utilisateur, RoleName roleName) {
        this.utilisateur = utilisateur;
        this.roleName = roleName;
    }
    
    
}
