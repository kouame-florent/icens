/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.localite.exception;

import javax.ejb.ApplicationException;

/**
 *
 * @author root
 */
@ApplicationException(rollback=true)
public class NotRequiredLocaliteException extends Exception{

    public NotRequiredLocaliteException() {
        super("La localité n'est pas du bon type.");
    }

    public NotRequiredLocaliteException(String message) {
        super(message);
    }
    
    
}
