/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.registre.service;

import io.icens.registre.domain.entity.Registre;
import io.icens.registre.domain.valueobject.ReferenceRegistre;
import io.icens.registre.domain.valueobject.StatutRegistre;
import io.icens.registre.domain.valueobject.TypeRegistre;
import io.icens.registre.exception.RegistreWithStatutsExistException;
import io.icens.registre.repository.RegistreDAO;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 *
 * @author root
 */
@Stateless
public class RegistreService {

    private static final Logger LOG = Logger.getLogger(RegistreService.class.getName());
       
    @Inject
    private ConfigService cfgSvc;
    
    @Inject
    private RegistreDAO registreDAO;
    
    @Inject
    MessagesService messagesService;
    
           
    public Optional<Registre> persist(Registre registre){
        return registreDAO.makePersistent(registre);
    }
                   
    public Registre newRegistre(@NotBlank String communeUuid,
            @NotBlank String centreUuid,int annee,
            @NotNull TypeRegistre typeRegistre) throws RegistreWithStatutsExistException{
        
        if(!registreDAO.findByRefCommuneCentreAnneeTypeAndStatutInStatuts(communeUuid,
                centreUuid,annee, typeRegistre,List.of(StatutRegistre.VALIDE,StatutRegistre.PROJET)).isEmpty()){
            
            throw new RegistreWithStatutsExistException(messagesService
                    .getMessage("exception.RegistreWithStatutsExistException"));
        }
        
        List<Registre> registresClotures = registreDAO.findByRefCommuneCentreAnneeTypeAndStatut(communeUuid, 
                centreUuid, annee, typeRegistre, StatutRegistre.CLOTURE);
        
        int num = generateNumeroRegistre(registresClotures);
        ReferenceRegistre ref = new ReferenceRegistre(communeUuid, centreUuid,annee,num,typeRegistre);
        Registre registre = new Registre(ref);
        
        registre.setNumeroPremierActe(generateNumeroPremierActe(registresClotures));
        registre.setNumeroDernierActe(generateNumeroDernierAct(registresClotures,typeRegistre));
        registre.setNombreActes(cfgSvc.getRegistreNombreActe(typeRegistre));
        
        return registre;
    }
    
    
    
    public int generateNumeroRegistre(List<Registre> registres){
        Optional<Registre> oReg = getRegistreWithMaxNumero(registres);
        return oReg.map(r -> r.getReference().getNumero() + 1).orElseGet(() -> 1);
       
    }
   
    public int generateNumeroPremierActe(@NotEmpty List<Registre> registres){
        Optional<Registre> oReg = registres.stream()
                .max(Comparator.comparing(r -> r.getReference()
                .getNumero()));
        
        return oReg.map(r -> r.getNumeroPremierActe() + r.getNombreActes() + 1)
                .orElseGet(() -> 1);
    }
    
    public int generateNumeroDernierAct(@NotEmpty List<Registre> registres,TypeRegistre typeRegistre){
       return generateNumeroPremierActe(registres) + cfgSvc.getRegistreNombreActe(typeRegistre);
    }
    
    private Optional<Registre>  getRegistreWithMaxNumero(@NotEmpty List<Registre> registres){
        return registres.stream()
                .max(Comparator.comparing(r -> r.getReference()
                .getNumero()));
    }
    
    
    public void validerRegistre(Registre registre){
        if(registre.getStatutRegistre().equals(StatutRegistre.PROJET)){
            registre.setStatutRegistre(StatutRegistre.VALIDE);
            registreDAO.makePersistent(registre);
        }
    }
    
    public void annuler(Registre registre){
        if(registre.getStatutRegistre().equals(StatutRegistre.PROJET)){
            registre.setStatutRegistre(StatutRegistre.ANNULE);
            registreDAO.makePersistent(registre);
        }
    }
    
    public void cloturer(Registre registre){
        if(registre.getStatutRegistre().equals(StatutRegistre.VALIDE)){
            registre.setStatutRegistre(StatutRegistre.CLOTURE);
            registreDAO.makePersistent(registre);
        }
    }

}
