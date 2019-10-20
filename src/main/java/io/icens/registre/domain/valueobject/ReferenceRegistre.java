/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.registre.domain.valueobject;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
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
@Embeddable
public class ReferenceRegistre implements Serializable{
     
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
}
