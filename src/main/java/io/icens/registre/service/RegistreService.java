/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.registre.service;

import io.icens.registre.domain.entity.Registre;
import io.icens.registre.domain.valueobject.ReferenceRegistre;
import io.icens.registre.repository.RegistreDAO;
import java.util.Optional;
import javax.ejb.Stateless;

/**
 *
 * @author root
 */
@Stateless
public class RegistreService {
    
    private RegistreDAO registreDAO;
   
    public Optional<Registre> findByReference(ReferenceRegistre reference){
        return registreDAO.findByReference(reference);
    }
    
    public Optional<Registre> creer(Registre registre){
        
        return Optional.empty();
    }
    
    public boolean exist(Registre registre){
        return registreDAO
                .findByReference(registre.getReference()).isEmpty();
    }
}
