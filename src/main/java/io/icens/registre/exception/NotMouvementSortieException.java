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
public class NotMouvementSortieException extends Exception{

    public NotMouvementSortieException() {
        super("Le mouvement n'est pas un mouvement de sortie.");
    }
    
        
     public NotMouvementSortieException(String message) {
        super(message);
    }
}
