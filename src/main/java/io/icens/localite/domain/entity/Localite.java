/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.localite.domain.entity;

import io.icens.localite.domain.valueobject.TypeLocalite;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author root
 */
@Table(name = "IC_LOCALITE")
@Getter @Setter
@Entity
public class Localite extends BaseEntity{
    
    @Column(name = "code")
    private String code;
    
    @NotBlank
    @Column(name = "nom")
    private String nom;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    private TypeLocalite typeLocalite;
        
    @Column(name = "parent_uuid")
    @ManyToOne
    private Localite parent;

    public Localite() {
    }

    public Localite(String nom, TypeLocalite typeLocalite, Localite parent) {
        this.nom = nom;
        this.typeLocalite = typeLocalite;
        this.parent = parent;
    }

    
    
}
