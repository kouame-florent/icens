/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.registre.repository;

import io.icens.shared.repository.GenericDAO;
import io.icens.registre.domain.entity.Registre;
import io.icens.registre.domain.valueobject.ReferenceRegistre;
import io.icens.registre.domain.valueobject.StatutRegistre;
import io.icens.registre.domain.valueobject.TypeRegistre;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author root
 */
public interface RegistreDAO extends GenericDAO<Registre, String>{
    
    Optional<Registre> findByReference(ReferenceRegistre reference);
    List<Registre> findByRefCommuneCentreAnneeType(String communeUuid,String centreUuid,int annee, 
            TypeRegistre typeRegistre);
    
    List<Registre> findByRefCommuneCentreAnneeTypeAndStatut(String communeUuid,String centreUuid,int annee, 
            TypeRegistre typeRegistre,StatutRegistre statutRegistre);
    
    List<Registre> findByRefCommuneCentreAnneeTypeAndStatutInStatuts(String communeUuid,String centreUuid,int annee, 
            TypeRegistre typeRegistre,List<StatutRegistre> statuts);
}
