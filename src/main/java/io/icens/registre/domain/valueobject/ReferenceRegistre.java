/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.registre.domain.valueobject;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @Column(name = "type_registre")
    @Enumerated(EnumType.STRING)
    private TypeRegistre typeRegistre;
    
    @Getter @Setter
    @Column(name = "commune_uuid")
    @NotBlank
    private String communeUuid;
     
    @Getter @Setter
    @Column(name = "centre_uuid")
    @NotBlank
    private String centreUuid;
    
    @Column(name = "annee")
    @Getter @Setter
    @Min(1900) @Max(2100)
    private int annee;
    
    @Getter @Setter
    @Column(name = "numero")
    private int numero;

    public ReferenceRegistre() {
    }

    public ReferenceRegistre(String communeUuid, 
            String centreUuid, int annee, int numero,TypeRegistre typeRegistre) {
        this.typeRegistre = typeRegistre;
        this.communeUuid = communeUuid;
        this.centreUuid = centreUuid;
        this.annee = annee;
        this.numero = numero;
    }
    
    
   
    
    
}
