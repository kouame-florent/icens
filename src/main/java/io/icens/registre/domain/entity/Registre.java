/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.registre.domain.entity;


import io.icens.registre.domain.valueobject.StatutRegistre;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author root
 */
@Table(name = "IC_REGISTRE",uniqueConstraints =  
      @UniqueConstraint(name = "UNQ_COMMUNE_CENTRE_ANNEE_NUMERO",
              columnNames = {"commune_uuid","centre_uuid","annee",""}
))
@Entity
public class Registre extends BaseEntity{
    
    @Column(name = "commune_uuid")
    @NotBlank
    String communeUuid;
    
    @Column(name = "centre_uuid")
    @NotBlank
    String centreUuid;
    
    @Column(name = "annee")
    @Getter @Setter
    @Min(1900) @Max(2100)
    int annee;
    
    @Column(name = "numero")
    @Positive
    long numero;
    
    @Column(name = "nombre_actes")
    @Getter @Setter
    @Positive
    long nombreActes;
    
    @Column(name = "numero_premier_acte")
    @Getter @Setter
    long numeroPremierActe;
    
    @Column(name = "numero_dernier_acte")
    @Getter @Setter
    long numeroDernierActe;
    
    @Column(name = "nombre_feuillets")
    @Getter @Setter
    @Positive
    int nombreDeFeuillets;
    
    @Column(name = "officier_uuid")
    @Getter @Setter
    @NotBlank
    String officierUuid;
    
    @Column(name = "tribunal_uuid")
    @Getter @Setter
    @NotBlank
    String tribunalUuid;
    
    @Getter @Setter
    @Enumerated(EnumType.STRING)
    StatutRegistre statut;
   
}
