/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.localite.service;

import io.icens.localite.domain.entity.Localite;
import io.icens.localite.domain.valueobject.TypeLocalite;
import java.util.Optional;
import javax.ejb.Stateless;

/**
 *
 * @author root
 */
@Stateless
public class LocaliteService {
        
    public Optional<Localite> newCommune(String nom,TypeLocalite typeLocalite,Localite parent){
        return Optional.empty();
    }
}
