/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.registre.domain.test;


import io.icens.registre.domain.entity.Registre;
import io.icens.registre.domain.valueobject.ReferenceRegistre;
import io.icens.registre.domain.valueobject.TypeRegistre;
import io.icens.registre.repository.RegistreDAO;
import io.icens.registre.service.RegistreService;
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
            .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
            .addAsResource("microprofile-config.properties", "META-INF/microprofile-config.properties")
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans" + ".xml");
         
        return war;
               
    }
    
    @Inject
    RegistreDAO registreDAO;
    
    @Inject
    RegistreService registreService;
    
    @Test
    @UsingDataSet(value = {"registre/registres.yml"})    
    public void shouldFindByReference(){
        ReferenceRegistre ref = new ReferenceRegistre( 
                "6dee3d50-90aa-4656-8269-673986d74aae","74514a75-7138-4230-9350-ce63b9fa3048",
                2020, 1,TypeRegistre.REGISTRE_DE_NAISSANCE);
        
        Optional<Registre> oReg = registreDAO.findByReference(ref);
        
         Assert.assertTrue(oReg.isPresent());
    }
    
    @Test
    @UsingDataSet(value = {"registre/registres.yml"})    
    public void shouldFindRegistreByRefCommuneCentreAnneType(){
        List<Registre> regs = registreDAO.findByRefCommuneCentreAnneeType("6dee3d50-90aa-4656-8269-673986d74aae", 
                "74514a75-7138-4230-9350-ce63b9fa3048", 
                2020, TypeRegistre.REGISTRE_DE_NAISSANCE);
        
         Assert.assertTrue(regs.size() == 1);
    }
  
    @Test
    public void shouldCreateFirstRegistre(){
       Registre reg = registreService.newRegistre("6dee3d50-90aa-4656-8269-673986d74aae", 
                "74514a75-7138-4230-9350-ce63b9fa3048", 2020, TypeRegistre.REGISTRE_DE_NAISSANCE);
       
       Assert.assertTrue(reg.getReference().getNumero() == 1);
    }
    
    @Test
    @UsingDataSet(value = {"registre/registres.yml"}) 
    public void shouldCreateSubsequentRegistre(){
       Registre reg = registreService.newRegistre("6dee3d50-90aa-4656-8269-673986d74aae", 
                "74514a75-7138-4230-9350-ce63b9fa3048", 2020, TypeRegistre.REGISTRE_DE_NAISSANCE);
       
       Assert.assertTrue(reg.getReference().getNumero() == 2);
    }
    
    @Test
    @ShouldMatchDataSet(value = {"registre/registres-created.yml"},excludeColumns 
            = {"uuid,version,created,updated,edited,date_ouverture,date_validation"})
    public void shouldCreateNewRegistreInEmptyDataBase(){
        Registre reg = registreService.newRegistre("6dee3d50-90aa-4656-8269-673986d74aae", 
                "74514a75-7138-4230-9350-ce63b9fa3048", 2020, TypeRegistre.REGISTRE_DE_NAISSANCE);
        
        reg.setOfficierUuid("50e92831-f1f6-4e1b-86d0-13b246d4dca6");
        reg.setTribunalUuid("d500cbe5-605d-45b4-aecd-9f0b5cd15508");
       
        Optional<Registre> oReg = registreService.persist(reg);
        
        Assert.assertTrue(oReg.isPresent());
    }
    
    @Test
    @UsingDataSet(value = {"registre/registres.yml"}) 
    @ShouldMatchDataSet(value = {"registre/registres-created-2-lines.yml"},
            excludeColumns = {"uuid,version,created,updated,edited,date_ouverture,date_validation"})
    public void shouldCreateNewRegistreInNotEmptyDB(){
        Registre reg = registreService.newRegistre("6dee3d50-90aa-4656-8269-673986d74aae", 
                "74514a75-7138-4230-9350-ce63b9fa3048", 2020, TypeRegistre.REGISTRE_DE_NAISSANCE);
        
        reg.setOfficierUuid("50e92831-f1f6-4e1b-86d0-13b246d4dca6");
        reg.setTribunalUuid("d500cbe5-605d-45b4-aecd-9f0b5cd15508");
       
        Optional<Registre> oReg = registreService.persist(reg);
        
        Assert.assertTrue(oReg.isPresent());
    }
    
}
