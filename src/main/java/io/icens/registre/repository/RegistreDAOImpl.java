/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.registre.repository;

import io.icens.registre.domain.entity.Registre;
import io.icens.registre.domain.valueobject.ReferenceRegistre;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author root
 */
@Stateless
public class RegistreDAOImpl extends GenericDAOImpl<Registre, String> implements RegistreDAO{

    public RegistreDAOImpl() {
        super(Registre.class);
    }

    @Override
    public Optional<Registre> findByReference(ReferenceRegistre reference) {
        TypedQuery<Registre> query = em.createNamedQuery("Registre.findByReference", Registre.class);
        query.setParameter("reference", reference);
       
        List<Registre> results =  query.getResultList();
        if(!results.isEmpty()){
            return Optional.of(results.get(0));
        }
        
        return Optional.empty();
    }
    
}
