/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.registre.exception;

import javax.ejb.ApplicationException;

/**
 *
 * @author root
 */
@ApplicationException(rollback=true)
public class RegistreWithStatutsExistException extends Exception{
     
    public RegistreWithStatutsExistException(String message) {
        super(message);
    }
  
}
