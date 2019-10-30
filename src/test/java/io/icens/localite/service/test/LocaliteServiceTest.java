/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.localite.service.test;


import java.io.File;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
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
            .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
            .addAsResource("microprofile-config.properties", "META-INF/microprofile-config.properties")
            .addAsResource(new File("src/main/resources/messages.properties"), "messages.properties")
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans" + ".xml");
         
        return war;
               
    }
    
    
}
