/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.registre.domain.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author root
 */
@NamedQueries({
    @NamedQuery(
        name = "RegistreDeNaissance.findByReference",
        query = "SELECT r FROM RegistreDeNaissance r WHERE r.reference = :reference"
    ),
   
})
@Entity
public class RegistreDeNaissance extends Registre{
    
}
