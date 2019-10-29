/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.registre.service.test;

import io.icens.registre.domain.entity.BaseEntity;
import io.icens.registre.domain.entity.Mouvement;
import io.icens.registre.domain.entity.Registre;
import io.icens.registre.service.MouvementService;
import io.icens.registre.service.RegistreService;
import java.io.File;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Optional;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.ShouldMatchDataSet;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author root
 */
@RunWith(Arquillian.class)
public class MouvementServiceTest {
    
    @Inject MouvementService mouvementService;
    @Inject RegistreService registreService;
   
    @Deployment
    public static WebArchive createDeployment() {
        WebArchive war = ShrinkWrap.create(WebArchive.class,
            RegistreServiceTest.class.getName() + ".war")
            .addPackages(true, "io.icens.registre.domain.interfaces")
            .addClasses(Registre.class,BaseEntity.class,Mouvement.class)
//            .addPackage("io.icens.registre.domain.entity")
            .addPackage("io.icens.registre.domain.valueobject")
            .addPackage("io.icens.registre.repository")
            .addPackage("io.icens.registre.service")
            .addPackage("io.icens.registre.exception")
            .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
            .addAsResource("microprofile-config.properties", "META-INF/microprofile-config.properties")
            .addAsResource(new File("src/main/resources/messages.properties"), "messages.properties")
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans" + ".xml");
         
        return war;
               
    }
    
    @Test
    @UsingDataSet(value = {"mouvement/shouldPersistNewMouvementInDB-seed.yml"}) 
    @ShouldMatchDataSet(value = {"mouvement/shouldPersistNewMouvementInDB-final.yml"},
            excludeColumns = {"uuid,version,created,updated,edited"})
    public void shouldPersistNewMouvementInDB(){
       Optional<Registre> oReg = registreService.findByUuid("b97d6945-18ee-44a7-aec1-0017cf077c52");
       Optional<Mouvement> oMouv = oReg.map(r -> mouvementService.newMouvement("2c26e69a-6e21-4a1c-a3ce-ceb3f83505db", r))
           .map(m -> { 
               m.setDateSortie(LocalDateTime.of(2019, Month.OCTOBER, 24, 15, 05, 03));
               m.setObjet("Consultation");
               return m;
           })
           .flatMap(m -> mouvementService.persist(m));
       
       Assert.assertTrue(oMouv.isPresent());
           
    }
}
