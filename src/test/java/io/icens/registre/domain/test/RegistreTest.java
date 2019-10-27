/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.registre.domain.test;


import io.icens.registre.domain.entity.Registre;
import io.icens.registre.domain.valueobject.ReferenceRegistre;
import io.icens.registre.domain.valueobject.StatutRegistre;
import io.icens.registre.domain.valueobject.TypeRegistre;
import io.icens.registre.exception.RegistreWithStatutsExistException;
import io.icens.registre.repository.RegistreDAO;
import io.icens.registre.service.RegistreService;
import java.io.File;
import java.util.List;
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
public class RegistreTest {
    
    @Deployment
    public static WebArchive createDeployment() {
        WebArchive war = ShrinkWrap.create(WebArchive.class,
            RegistreTest.class.getName() + ".war")
            .addPackages(true, "io.icens.registre.domain.interfaces")
            .addPackage("io.icens.registre.domain.entity")
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
    
    @Inject
    RegistreDAO registreDAO;
    
    @Inject
    RegistreService registreService;
    
    @Test
    @UsingDataSet(value = {"registre/shouldFindByReference-seed.yml"})    
    public void shouldFindByReference(){
        ReferenceRegistre ref = new ReferenceRegistre( 
                "6dee3d50-90aa-4656-8269-673986d74aae","74514a75-7138-4230-9350-ce63b9fa3048",
                2020, 1,TypeRegistre.REGISTRE_DE_NAISSANCE);
        
        Optional<Registre> oReg = registreDAO.findByReference(ref);
        
         Assert.assertTrue(oReg.isPresent());
    }
    
    @Test
    @UsingDataSet(value = {"registre/shouldFindRegistreByRefCommuneCentreAnneType-seed.yml"})    
    public void shouldFindRegistreByRefCommuneCentreAnneType(){
        List<Registre> regs = registreDAO.findByRefCommuneCentreAnneeType("6dee3d50-90aa-4656-8269-673986d74aae", 
                "74514a75-7138-4230-9350-ce63b9fa3048", 
                2020, TypeRegistre.REGISTRE_DE_NAISSANCE);
        
         Assert.assertTrue(regs.size() == 1);
    }
  
    @Test
    public void shouldCreateFirstRegistre() throws RegistreWithStatutsExistException{
       Registre reg = registreService.newRegistre("6dee3d50-90aa-4656-8269-673986d74aae", 
                "74514a75-7138-4230-9350-ce63b9fa3048", 2020, TypeRegistre.REGISTRE_DE_NAISSANCE);
       
       Assert.assertTrue(reg.getReference().getNumero() == 1);
    }
    
    @Test
    @UsingDataSet(value = {"registre/shouldCreateSubsequentRegistre-seed.yml"}) 
    public void shouldCreateSubsequentRegistre() throws RegistreWithStatutsExistException{
       Registre reg = registreService.newRegistre("6dee3d50-90aa-4656-8269-673986d74aae", 
                "74514a75-7138-4230-9350-ce63b9fa3048", 2020, TypeRegistre.REGISTRE_DE_NAISSANCE);
       
       Assert.assertTrue(reg.getReference().getNumero() == 2);
    }
    
    @Test
    @UsingDataSet(value = {"registre/shouldCreateSubsequentRegistreEvenWithRegistreWithStatutAnnule-seed.yml"}) 
    public void shouldCreateSubsequentRegistreEvenWithRegistreWithStatutAnnule() throws RegistreWithStatutsExistException{
       Registre reg = registreService.newRegistre("6dee3d50-90aa-4656-8269-673986d74aae", 
                "74514a75-7138-4230-9350-ce63b9fa3048", 2020, TypeRegistre.REGISTRE_DE_NAISSANCE);
       
       Assert.assertTrue(reg.getReference().getNumero() == 3);
    }
    
    @Test
    @UsingDataSet(value = {"registre/shouldFailToCreateSubsequentRegistre-seed.yml"}) 
    public void shouldFailToCreateSubsequentRegistre(){
        boolean gotExpectedException = false;
        try {
            registreService.newRegistre("6dee3d50-90aa-4656-8269-673986d74aae",
                    "74514a75-7138-4230-9350-ce63b9fa3048", 2020, TypeRegistre.REGISTRE_DE_NAISSANCE);
           
        } catch (RegistreWithStatutsExistException ex) {
            gotExpectedException = true;
        }
        
         Assert.assertTrue("Des registres avec le statut VALIDE OU PROJET exixtent.",gotExpectedException);
    }
    
    @Test
    @ShouldMatchDataSet(value = {"registre/shouldPersitNewRegistreInEmptyDataBase-final.yml"},excludeColumns 
            = {"uuid,version,created,updated,edited,date_ouverture,date_validation"})
    public void shouldPersitNewRegistreInEmptyDataBase() throws RegistreWithStatutsExistException{
        Registre reg = registreService.newRegistre("6dee3d50-90aa-4656-8269-673986d74aae", 
                "74514a75-7138-4230-9350-ce63b9fa3048", 2020, TypeRegistre.REGISTRE_DE_NAISSANCE);
        
        reg.setOfficierUuid("50e92831-f1f6-4e1b-86d0-13b246d4dca6");
        reg.setTribunalUuid("d500cbe5-605d-45b4-aecd-9f0b5cd15508");
       
        Optional<Registre> oReg = registreService.persist(reg);
        
        Assert.assertTrue(oReg.isPresent());
    }
    
    @Test
    @UsingDataSet(value = {"registre/shouldPersitNewRegistreInNotEmptyDB-seed.yml"}) 
    @ShouldMatchDataSet(value = {"registre/shouldPersitNewRegistreInNotEmptyDB-final.yml"},
            excludeColumns = {"uuid,version,created,updated,edited,date_ouverture,date_validation"})
    public void shouldPersitNewRegistreInNotEmptyDB() throws RegistreWithStatutsExistException{
        Registre reg = registreService.newRegistre("6dee3d50-90aa-4656-8269-673986d74aae", 
                "74514a75-7138-4230-9350-ce63b9fa3048", 2020, TypeRegistre.REGISTRE_DE_NAISSANCE);
        
        reg.setOfficierUuid("50e92831-f1f6-4e1b-86d0-13b246d4dca6");
        reg.setTribunalUuid("d500cbe5-605d-45b4-aecd-9f0b5cd15508");
       
        Optional<Registre> oReg = registreService.persist(reg);
        oReg.ifPresent(r -> Assert.assertTrue(r.getStatutRegistre() == StatutRegistre.PROJET));
        
        Assert.assertTrue(oReg.isPresent());
    }
    
    @Test
    @UsingDataSet(value = {"registre/shouldValidateProjetRegistre-seed.yml"}) 
    @ShouldMatchDataSet(value = {"registre/shouldValidateProjetRegistre-final.yml"},
            excludeColumns = {"uuid,version,created,updated,edited,date_ouverture,date_validation"})
    public void shouldValidateProjetRegistre(){
        
        Optional<Registre> oReg = registreDAO.findById("b97d6945-18ee-44a7-aec1-0017cf077c52");
        oReg.ifPresent(r -> r.setStatutRegistre(StatutRegistre.VALIDE));
    }
    
    @Test
    @UsingDataSet(value = {"registre/shouldDisableValidRegistre-seed.yml"}) 
    @ShouldMatchDataSet(value = {"registre/shouldDisableValidRegistre-final.yml"},
            excludeColumns = {"uuid,version,created,updated,edited,date_ouverture,date_validation"})
    public void shouldDisableValidRegistre(){
        
        Optional<Registre> oReg = registreDAO.findById("b97d6945-18ee-44a7-aec1-0017cf077c52");
        oReg.ifPresent(r -> r.setStatutRegistre(StatutRegistre.ANNULE));
    }
    
    @Test
    @UsingDataSet(value = {"registre/shouldCloseValidRegistre-seed.yml"}) 
    @ShouldMatchDataSet(value = {"registre/shouldCloseValidRegistre-final.yml"},
            excludeColumns = {"uuid,version,created,updated,edited,date_ouverture,date_validation"})
    public void shouldCloseValidRegistre(){
        
        Optional<Registre> oReg = registreDAO.findById("b97d6945-18ee-44a7-aec1-0017cf077c52");
        oReg.ifPresent(r -> r.setStatutRegistre(StatutRegistre.CLOTURE));
    }
    
    
}
