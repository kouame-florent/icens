/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.registre.repository;

import io.icens.registre.domain.entity.TypeRegistre;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author root
 */
@Stateless
public class TypeRegistreDAOImpl extends GenericDAOImpl<TypeRegistre, String> implements TypeRegistreDAO{
    
    public TypeRegistreDAOImpl() {
        super(TypeRegistre.class);
    }
    
}
