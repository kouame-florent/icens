/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.acteur.repository;

import io.icens.acteur.domain.entity.Administrateur;
import io.icens.registre.repository.GenericDAOImpl;
import javax.ejb.Stateless;

/**
 *
 * @author root
 */
@Stateless
public class AdministrateurDAOImpl extends GenericDAOImpl<Administrateur, String> implements AdministrateurDAO{
    
    public AdministrateurDAOImpl() {
        super(Administrateur.class);
    }
    
}
