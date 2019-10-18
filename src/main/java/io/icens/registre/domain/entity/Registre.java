/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.registre.domain.entity;

import io.icens.registre.domain.valueobject.AnneeRegistre;
import io.icens.registre.domain.valueobject.NombreActe;
import io.icens.registre.domain.valueobject.NumerDernierActe;
import io.icens.registre.domain.valueobject.NumeroPremierActe;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author root
 */
@Table(name = "IC_REGISTRE")
@Entity
public class Registre extends BaseEntity{
    
    @Getter @Setter
    @Embedded
    AnneeRegistre anneeRegistre;
    
    @Getter @Setter
    @Embedded
    NombreActe nombreActe;
    
    @Getter @Setter
    @Embedded
    NumeroPremierActe numeroPremierActe;
    
    @Getter @Setter
    @Embedded
    NumerDernierActe numerDernierActe;
    
    @Getter @Setter
    String officierUuid;
    
    @Getter @Setter
    String tribunalUuid;
   
}
