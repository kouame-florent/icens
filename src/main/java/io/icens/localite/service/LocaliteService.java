/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.localite.service;

import io.icens.localite.domain.entity.Localite;
import io.icens.localite.domain.valueobject.TypeLocalite;
import io.icens.localite.exception.NotRequiredLocaliteException;
import io.icens.localite.repository.LocaliteDAO;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author root
 */
@Stateless
public class LocaliteService {

    @Inject LocaliteDAO localiteDAO;
    
    public Optional<Localite> findByUuid(String uuid){
        return localiteDAO.findById(uuid);
    }
    
    public Localite newLocalite(String nom,TypeLocalite typeLocalite,Localite parent){
        return new Localite(nom,typeLocalite, parent);
    }
    
    public Localite newCommune(String nom,Localite parent) 
            throws NotRequiredLocaliteException{
        
        if(!parent.getTypeLocalite().equals(TypeLocalite.DEPARTEMENT)){
            throw new NotRequiredLocaliteException("La localité n'est pas un "
                    + TypeLocalite.DEPARTEMENT.type());    
        }
        
        return new Localite(nom,TypeLocalite.COMMUNE, parent);
    }
}
