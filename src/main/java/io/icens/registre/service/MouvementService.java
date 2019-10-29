/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.registre.service;

import io.icens.registre.domain.entity.Mouvement;
import io.icens.registre.domain.entity.Registre;
import io.icens.registre.domain.valueobject.EtatMouvementRegistre;
import io.icens.registre.exception.NotMouvementSortieException;
import io.icens.registre.repository.MouvementDAO;
import java.time.LocalDateTime;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author root
 */
@Stateless
public class MouvementService {
    
    @Inject MouvementDAO mouvementDAO;
    
    public Mouvement newMouvement(String agentUuid,Registre registre){
        Mouvement mouvement = new Mouvement(agentUuid, registre, EtatMouvementRegistre.SORTIE);
        mouvement.setDateSortie(LocalDateTime.now());
        return mouvement;
    }
    
    public Optional<Mouvement> updateToMouvementRetour(Mouvement mouvementSortie) 
            throws NotMouvementSortieException{
        if(!mouvementSortie.getEtatMouvementRegistre().equals(EtatMouvementRegistre.SORTIE)){
           throw new NotMouvementSortieException();
        }
        mouvementSortie.setEtatMouvementRegistre(EtatMouvementRegistre.RETOUR);
        mouvementSortie.setDateRetour(LocalDateTime.now());
        return mouvementDAO.makePersistent(mouvementSortie);
        
    }
    
    public Optional<Mouvement> persist(Mouvement mouvement){
       return mouvementDAO.makePersistent(mouvement);
    }
}
