/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.registre.domain.entity;


import io.icens.registre.domain.valueobject.ReferenceRegistre;
import io.icens.registre.domain.valueobject.StatutRegistre;
import io.icens.shared.domain.entity.BaseEntity;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.SafeHtml;

/**
 *
 * @author root
 */
@NamedQueries({
    @NamedQuery(
        name = "Registre.findByReference",
        query = "SELECT r FROM Registre r WHERE r.reference = :reference"
    ),
    @NamedQuery(
        name = "Registre.findByRefCommuneCentreAnneeType",
        query = "SELECT r FROM Registre r WHERE r.reference.communeUuid = :communeUuid "
                + " AND r.reference.centreUuid = :centreUuid "
                + " AND r.reference.annee = :annee "
                + " AND r.reference.typeRegistre = :typeRegistre"
    ),
    @NamedQuery(
        name = "Registre.findByRefCommuneCentreAnneeTypeAndStatut",
        query = "SELECT r FROM Registre r WHERE r.reference.communeUuid = :communeUuid "
                + " AND r.reference.centreUuid = :centreUuid "
                + " AND r.reference.annee = :annee "
                + " AND r.reference.typeRegistre = :typeRegistre"
                + " AND r.statutRegistre = :statutRegistre"
    ),
    @NamedQuery(
        name = "Registre.findByRefCommuneCentreAnneeTypeAndStatutInStatuts",
        query = "SELECT r FROM Registre r WHERE r.reference.communeUuid = :communeUuid "
                + " AND r.reference.centreUuid = :centreUuid "
                + " AND r.reference.annee = :annee "
                + " AND r.reference.typeRegistre = :typeRegistre"
                + " AND r.statutRegistre IN :statuts"
    ),
   
})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "IC_REGISTRE",uniqueConstraints =  
      @UniqueConstraint(name = "UNQ_COMMUNE_CENTRE_ANNEE_NUMERO",
              columnNames = {"commune_uuid","centre_uuid","annee","numero","type_registre"}
))
@Entity
public class Registre extends BaseEntity{
        
    @NotNull
    @Getter @Setter
    @Embedded
    @Valid
    private ReferenceRegistre reference;
    
    @Column(name = "nombre_actes")
    @Getter @Setter
    @Positive
    private int nombreActes;
    
    @Column(name = "numero_premier_acte")
    @Getter @Setter
    private int numeroPremierActe;
    
    @Column(name = "numero_dernier_acte")
    @Getter @Setter
    private int numeroDernierActe;
    
//    @Column(name = "nombre_feuillets")
//    @Getter @Setter
//    private int nombreFeuillets;
        
    @NotNull
    @Column(name = "date_ouverture")
    @Getter @Setter
    private LocalDateTime dateOuverture = LocalDateTime.now();
    
    @Column(name = "date_validation")
    @Getter @Setter
    private LocalDateTime dateValidation;
    
    @Column(name = "observation")
    @Getter @Setter
    @Size(min = 0,max = 1000)
    @SafeHtml
    private String observation = "";
    
    @Column(name = "mention")
    @Getter @Setter
    @Size(min = 0,max = 1000)
    @SafeHtml
    private String mention;
    
    @Column(name = "motif_annulation")
    @Getter @Setter
    @Size(min = 0,max = 1000)
    @SafeHtml
    private String motifAnnulation;
    
    @Column(name = "officier_uuid")
    @Getter @Setter
    @NotBlank
    private String officierUuid;
    
    @Column(name = "tribunal_uuid")
    @Getter @Setter
    @NotBlank
    private String tribunalUuid;
    
    @Column(name = "statut_registre")
    @Getter @Setter
    @Enumerated(EnumType.STRING)
    private StatutRegistre statutRegistre = StatutRegistre.PROJET;
    
    public Registre(ReferenceRegistre reference) {
        this.reference = reference;
        
    }

    public Registre() {
       
    }
       
}
