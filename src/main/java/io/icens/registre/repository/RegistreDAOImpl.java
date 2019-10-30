/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.registre.repository;

import io.icens.shared.repository.GenericDAOImpl;
import io.icens.registre.domain.entity.Registre;
import io.icens.registre.domain.valueobject.ReferenceRegistre;
import io.icens.registre.domain.valueobject.StatutRegistre;
import io.icens.registre.domain.valueobject.TypeRegistre;
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

    @Override
    public List<Registre> findByRefCommuneCentreAnneeType(String communeUuid, 
            String centreUuid, int annee, TypeRegistre typeRegistre) {
        
        TypedQuery<Registre> query = 
                em.createNamedQuery("Registre.findByRefCommuneCentreAnneeType", Registre.class);
        
        query.setParameter("communeUuid", communeUuid);
        query.setParameter("centreUuid", centreUuid);
        query.setParameter("annee", annee);
        query.setParameter("typeRegistre", typeRegistre);
       
        return query.getResultList();
    }

    @Override
    public List<Registre> findByRefCommuneCentreAnneeTypeAndStatut(String communeUuid, String centreUuid, 
            int annee, TypeRegistre typeRegistre, StatutRegistre statutRegistre) {
          
        TypedQuery<Registre> query = 
                em.createNamedQuery("Registre.findByRefCommuneCentreAnneeTypeAndStatut", Registre.class);
        
        query.setParameter("communeUuid", communeUuid);
        query.setParameter("centreUuid", centreUuid);
        query.setParameter("annee", annee);
        query.setParameter("typeRegistre", typeRegistre);
        query.setParameter("statutRegistre", statutRegistre);
       
        return query.getResultList();
    }

    @Override
    public List<Registre> findByRefCommuneCentreAnneeTypeAndStatutInStatuts(String communeUuid, String centreUuid, 
            int annee, TypeRegistre typeRegistre, List<StatutRegistre> statuts) {
        TypedQuery<Registre> query = 
                em.createNamedQuery("Registre.findByRefCommuneCentreAnneeTypeAndStatutInStatuts", Registre.class);
        
        query.setParameter("communeUuid", communeUuid);
        query.setParameter("centreUuid", centreUuid);
        query.setParameter("annee", annee);
        query.setParameter("typeRegistre", typeRegistre);
        query.setParameter("statuts", statuts);
       
        return query.getResultList();
    }
    
}
