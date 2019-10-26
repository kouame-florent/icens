/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.registre.service;

import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;

/**
 *
 * @author root
 */
@ApplicationScoped
public class MessagesService {
    
    private ResourceBundle messageBundle;
    
    @PostConstruct
    public void init(){
        messageBundle = ResourceBundle.getBundle("messages");
    }
    
    public String getMessage(String key){
       return messageBundle.getString(key);
    }
}
