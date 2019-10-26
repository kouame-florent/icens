/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.registre.exception;

import io.icens.registre.domain.valueobject.StatutRegistre;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.ApplicationException;

/**
 *
 * @author root
 */
@ApplicationException(rollback=true)
public class RegistreWithStatutsExistException extends Exception{
    
    private String message;

    public RegistreWithStatutsExistException(String message) {
        super(message);
    }
    
    
}
