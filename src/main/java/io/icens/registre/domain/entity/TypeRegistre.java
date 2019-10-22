/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.registre.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
//@NamedQueries({
//    @NamedQuery(
//        name = "TypeRegistre.findByCode",
//        query = "SELECT t FROM TypeRegistre t WHERE t.uu = :code"
//    ),
//   
//})
@Table(name = "IC_TYPE_REGISTRE")
@Entity
public class TypeRegistre extends BaseEntity{
    

    @Column(name = "libelle")
    @Getter @Setter
    @Size(min = 0,max = 200)
    @SafeHtml
    private String libelle;
        
    @Column(name = "nombre_de_feuillets")
    @Getter @Setter
    @Positive
    int nombreDeFeuillets = 50;

    public TypeRegistre() {
    }

    public TypeRegistre(String libelle, int nombreDeFeuillets) {
        this.libelle = libelle;
        this.nombreDeFeuillets = nombreDeFeuillets;
    }
    
    
    
}
