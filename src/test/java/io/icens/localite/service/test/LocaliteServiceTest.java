/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.localite.service.test;


import io.icens.localite.domain.entity.Localite;
import io.icens.localite.exception.NotRequiredLocaliteException;
import io.icens.localite.service.LocaliteService;
import java.io.File;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class LocaliteServiceTest {
    
    
    @Deployment
    public static WebArchive createDeployment() {
        WebArchive war = ShrinkWrap.create(WebArchive.class,
            LocaliteServiceTest.class.getName() + ".war")
            .addPackage("io.icens.shared.interfaces")
            .addPackage("io.icens.shared.domain.entity")
            .addPackage("io.icens.shared.repository")
            .addPackage("io.icens.localite.domain.entity")
            .addPackage("io.icens.localite.domain.valueobject")
            .addPackage("io.icens.localite.repository")
            .addPackage("io.icens.localite.service")
            .addPackage("io.icens.localite.exception")
            .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
            .addAsResource("microprofile-config.properties", "META-INF/microprofile-config.properties")
            .addAsResource(new File("src/main/resources/messages.properties"), "messages.properties")
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans" + ".xml");
         
        return war;
               
    }
    
    @Inject LocaliteService localiteService;
    
    @Test
    public void shouldInjectService(){
        Assert.assertNotNull(localiteService);
    }
    
    
    @Test
    @UsingDataSet(value = {"localite/shouldCreateNewCommune-seed.yml"})  
    public void shouldCreateNewCommune() {
        Optional<Localite> oLoc = localiteService.findByUuid("39a7f8b6-9a26-408c-95e9-3755a86844d0");
        Optional<Localite> oCom = oLoc.map(l -> newCommune_("Daloa", l));
        Assert.assertTrue(oCom.isPresent());
    }
    
    private Localite newCommune_(String nom,Localite localite){
        try {
            return localiteService.newCommune(nom, localite);
        } catch (NotRequiredLocaliteException ex) {
            throw  new RuntimeException(ex);
        }
    }
//    @Test
//    public void shouldThrowNotRequiredLocalException() {
//         boolean gotExpectedException = false;
//         Localite loc = localiteService.findByUuid("39a7f8b6-9a26-408c-95e9-3755a86844d0").get();
//        try {
//            localiteService.newCommune("Daloa", loc);
//           
//        } catch (NotRequiredLocaliteException ex) {
//            gotExpectedException = true;
//        }
//        
//         Assert.assertTrue("La localité n'est pas un département.",gotExpectedException);
//   
//    }
}
