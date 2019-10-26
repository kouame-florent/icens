/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.registre.service;

import io.icens.registre.domain.valueobject.TypeRegistre;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;

/**
 *
 * @author root
 */
@ApplicationScoped
public class ConfigService {
    
    private Config config;
        
    @PostConstruct
    public void init(){
        config = ConfigProvider.getConfig();
    }
    
    public int getRegistreNombreActe(TypeRegistre typeRegistre){
       switch(typeRegistre){
           case REGISTRE_DES_ACTES_DIVERS:
               return config.getValue("registre.actes.divers.nombre.actes.par.defaut", Integer.class);
           case REGISTRE_DE_DECES:
               return config.getValue("registre.deces.nombre.actes.par.defaut", Integer.class);
           case REGISTRE_DE_MARIAGE:
               return config.getValue("registre.mariage.nombre.actes.par.defaut", Integer.class);
           case REGISTRE_DE_NAISSANCE:
               return config.getValue("registre.naissance.nombre.actes.par.defaut", Integer.class);

           default:
               return 0;
       }
       
    }
}
