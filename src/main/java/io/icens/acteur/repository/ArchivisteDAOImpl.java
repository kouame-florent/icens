/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.acteur.repository;

import io.icens.acteur.domain.entity.Archiviste;
import javax.ejb.Stateless;

/**
 *
 * @author root
 */
@Stateless
public class ArchivisteDAOImpl extends GenericDAOImpl<Archiviste, String> implements ArchivisteDAO{
    
    public ArchivisteDAOImpl() {
        super(Archiviste.class);
    }
    
}
