/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.registre.repository;

import io.icens.registre.domain.entity.RegistreDeNaissance;
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
public class RegistreDeNaissanceDAOImpl extends GenericDAOImpl<RegistreDeNaissance, String> 
        implements RegistreDeNaissanceDAO{
    
    public RegistreDeNaissanceDAOImpl() {
        super(RegistreDeNaissance.class);
    }

    @Override
    public Optional<RegistreDeNaissance> findByReference(ReferenceRegistre reference) {
         TypedQuery<RegistreDeNaissance> query = 
               em.createNamedQuery("RegistreDeNaissance.findByReference", RegistreDeNaissance.class);
         
        query.setParameter("reference", reference);
       
        List<RegistreDeNaissance> results =  query.getResultList();
        if(!results.isEmpty()){
            return Optional.of(results.get(0));
        }
        
        return Optional.empty();
    }
    
}
