/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.registre.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.SafeHtml;

/**
 *
 * @author root
 */
@Entity
public class TypeRegistre extends BaseEntity{
    
    @Column(name = "nombre_actes")
    @Getter @Setter
    @Positive
    private int code;
    
    @Column(name = "libelle")
    @Getter @Setter
    @Size(min = 0,max = 200)
    @SafeHtml
    private String libelle;
}
