/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.acteur.repository;

import io.icens.acteur.domain.entity.Requerant;
import javax.ejb.Stateless;

/**
 *
 * @author root
 */
@Stateless
public class RequerantDAOImpl extends GenericDAOImpl<Requerant, String> implements RequerantDAO{
    
    public RequerantDAOImpl() {
        super(Requerant.class);
    }
    
}
