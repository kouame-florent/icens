/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.registre.domain.test;


import io.icens.registre.domain.entity.Registre;
import io.icens.registre.domain.entity.TypeRegistre;
import io.icens.registre.domain.valueobject.ReferenceRegistre;
import io.icens.registre.repository.TypeRegistreDAO;
import io.icens.registre.service.RegistreService;
import java.util.Optional;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.persistence.ShouldMatchDataSet;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author root
 */
//@RunWith(Arquillian.class)
public class RegistreTest {
    
//    @Deployment
//    public static WebArchive createDeployment() {
//        WebArchive war = ShrinkWrap.create(WebArchive.class,
//            RegistreTest.class.getName() + ".war")
//            .addPackages(true, "io.icens.registre.domain.interfaces")
//            .addPackage("io.icens.registre.domain.entity")
//            .addPackage("io.icens.registre.domain.valueobject")
//            .addPackage("io.icens.registre.repository")
//            .addPackage("io.icens.registre.service")
//            .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
//            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans" + ".xml");
//         
//        return war;
//               
//    }
//    
//    @Inject
//    RegistreService registreService;
//    
//    @Inject
//    TypeRegistreDAO typeRegistreDAO;
//    
//    @Test
//    @UsingDataSet(value = {"typeregistre/type-registres.yml"})    
//    @ShouldMatchDataSet(value = {"registre/registres-created.yml"},excludeColumns = {"uuid,version,created,updated,edited"})
//    public void shouldCreateNewRegistre(){
//        Optional<TypeRegistre> oType = typeRegistreDAO.findById("b97d6945-18ee-44a7-aec1-0017cf077c52");
//        Optional<Registre> oReg = oType.map(t -> new ReferenceRegistre(t, "0d3ed11a-c638-460e-ba29-8732d9a88486 ", 2020, 1))
//             .map(ref -> new Registre(ref))
//             .flatMap(reg -> registreService.creer(reg));
//        
//         Assert.assertTrue(oReg.isPresent());
//    }
}
