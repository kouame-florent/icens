/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.localite.repository;

import io.icens.localite.domain.entity.Localite;
import io.icens.shared.repository.GenericDAOImpl;
import javax.ejb.Stateless;

/**
 *
 * @author root
 */
@Stateless
public class LocaliteDAOImpl extends GenericDAOImpl<Localite, String> implements LocaliteDAO{

    public LocaliteDAOImpl() {
        super(Localite.class);
    }
    
}
