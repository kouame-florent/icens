/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.registre.service;

import io.icens.registre.domain.entity.Registre;
import io.icens.registre.domain.valueobject.ReferenceRegistre;
import io.icens.registre.domain.valueobject.TypeRegistre;
import io.icens.registre.repository.RegistreDAO;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 *
 * @author root
 */
@Stateless
public class RegistreService {

    private static final Logger LOG = Logger.getLogger(RegistreService.class.getName());
       
    @Inject
    @ConfigProperty(name = "REGISTRE_DE_NAISSANCE_NOMBRE_ACTES")
    private int nombreActes;
    
    @Inject
    private RegistreDAO registreDAO;
        
    public Optional<Registre> persist(Registre registre){
        return registreDAO.makePersistent(registre);
    }
                   
    public Registre newRegistre(@NotBlank String communeUuid,
            @NotBlank String centreUuid,int annee,
            @NotNull TypeRegistre typeRegistre){
        
        List<Registre> registres = registreDAO.findByRefCommuneCentreAnneeType(communeUuid, centreUuid, 
                annee, typeRegistre);
        
        int num = genererNumeroRegistre(registres);
        ReferenceRegistre ref = new ReferenceRegistre(communeUuid, centreUuid,annee,num,typeRegistre);
        Registre registre = new Registre(ref);
        
        registre.setNumeroPremierActe(generateNumeroPremierActe(registres));
        registre.setNumeroDernierActe(generateNumeroDernierAct(registres));
        registre.setNombreActes(nombreActes);
        
        return registre;
    }
    
    public int genererNumeroRegistre(List<Registre> registres){
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
    
    public int generateNumeroDernierAct(@NotEmpty List<Registre> registres){
       return generateNumeroPremierActe(registres) + nombreActes;
    }
    
    private Optional<Registre>  getRegistreWithMaxNumero(@NotEmpty List<Registre> registres){
        return registres.stream()
                .max(Comparator.comparing(r -> r.getReference()
                .getNumero()));
    }

}
