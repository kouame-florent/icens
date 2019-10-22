/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.registre.domain.valueobject;

import io.icens.registre.domain.entity.TypeRegistre;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author root
 */
@Embeddable
public class ReferenceRegistre implements Serializable{
    
    @NotNull
    @Getter @Setter
    @Valid
    @ManyToOne
    private TypeRegistre typeRegistre;
    
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
    
    @Getter @Setter
    @Column(name = "numero")
    @Positive
    long numero;

    public ReferenceRegistre() {
    }
    
    
    
    public ReferenceRegistre(TypeRegistre typeRegistre,String centreUuid, int annee, long numero) {
        this.typeRegistre = typeRegistre;
        this.centreUuid = centreUuid;
        this.annee = annee;
        this.numero = numero;
    }
    
    
}
