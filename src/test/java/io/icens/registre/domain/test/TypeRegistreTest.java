/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.registre.domain.test;

import io.icens.registre.domain.entity.TypeRegistre;
import io.icens.registre.repository.TypeRegistreDAO;
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
public class TypeRegistreTest {
    
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
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans" + ".xml");
         
        return war;
               
    }
    
    @Inject
    TypeRegistreDAO typeRegistreDAO;
    
    @Test
    @UsingDataSet(value = {"typeregistre/type-registres.yml"})    
    public void shouldFindTypeRegistreByUuid(){
        Optional<TypeRegistre> oType = typeRegistreDAO.findById("b97d6945-18ee-44a7-aec1-0017cf077c52");
        Assert.assertTrue(oType.isPresent());
    }
    
    
    @Test
    @ShouldMatchDataSet(value = {"typeregistre/type-registres-created.yml"},excludeColumns = {"uuid,version,created,updated,edited"})
    public void shouldCreateNewTypeRegistre(){
        TypeRegistre typeRegistre = new TypeRegistre("Registre de decès",20);
        typeRegistre.setUuid("476ec14e-1eec-429e-a111-87aa624325a6");
        Optional<TypeRegistre> oType = typeRegistreDAO.makePersistent(typeRegistre);
        Assert.assertTrue(oType.isPresent());
                
    }
    
    @Test
    @UsingDataSet(value = {"typeregistre/type-registres.yml"})    
    @ShouldMatchDataSet(value = {"typeregistre/type-registres-updated.yml"},excludeColumns = {"uuid,version,created,updated,edited"})
    public void shouldUpdateTypeRegistre(){
        Optional<TypeRegistre> oType = typeRegistreDAO.findById("b97d6945-18ee-44a7-aec1-0017cf077c52");
        oType.ifPresent(t -> {
            t.setLibelle("Registre des actes divers");
            t.setNombreDeFeuillets(30);
                
            });
        Assert.assertTrue(oType.isPresent());
                
    }
    
    @Test
    @UsingDataSet(value = {"typeregistre/type-registres.yml"})    
    public void shouldDeleteTypeRegistre(){
        
        Optional<TypeRegistre> oType = typeRegistreDAO.findById("b97d6945-18ee-44a7-aec1-0017cf077c52");
        oType.ifPresent(t -> typeRegistreDAO.makeTransient(t));

        List<TypeRegistre> rgs = typeRegistreDAO.findAll();
        Assert.assertTrue(rgs.isEmpty());
    }
    
}
