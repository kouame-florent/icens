/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.acteur.repository;

import io.icens.acteur.domain.entity.ChefEtatCivil;
import io.icens.shared.repository.GenericDAOImpl;
import javax.ejb.Stateless;


/**
 *
 * @author root
 */
@Stateless
public class ChefEtatCivilDAOImpl extends GenericDAOImpl<ChefEtatCivil, String> implements ChefEtatCivilDAO{
    
    public ChefEtatCivilDAOImpl() {
        super(ChefEtatCivil.class);
    }
    
}
