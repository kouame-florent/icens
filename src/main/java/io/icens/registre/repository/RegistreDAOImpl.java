/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.registre.repository;

import io.icens.registre.domain.entity.Registre;
import javax.ejb.Stateless;

/**
 *
 * @author root
 */
@Stateless
public class RegistreDAOImpl extends GenericDAOImpl<Registre, String> implements RegistreDAO{

    public RegistreDAOImpl() {
        super(Registre.class);
    }
    
}
