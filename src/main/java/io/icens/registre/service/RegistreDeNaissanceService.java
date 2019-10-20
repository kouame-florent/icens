/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.registre.service;

import io.icens.registre.domain.entity.RegistreDeNaissance;
import io.icens.registre.repository.RegistreDeNaissanceDAO;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author root
 */
@Stateless
public class RegistreDeNaissanceService {
    
    @Inject
    private RegistreDeNaissanceDAO registreDeNaissanceDAO;
    
    
    public Optional<RegistreDeNaissance> creer(RegistreDeNaissance registreDeNaissance){
       
        return isUnique(registreDeNaissance) ? 
                registreDeNaissanceDAO.makePersistent(registreDeNaissance)
                : Optional.empty();
    }
    
    private boolean isUnique(RegistreDeNaissance registreDeNaissance){
      return registreDeNaissanceDAO
              .findByReference(registreDeNaissance.getReference()).isEmpty();
    }
}
