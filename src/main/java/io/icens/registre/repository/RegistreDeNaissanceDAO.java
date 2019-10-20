/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.registre.repository;

import io.icens.registre.domain.entity.RegistreDeNaissance;
import io.icens.registre.domain.valueobject.ReferenceRegistre;
import java.util.Optional;

/**
 *
 * @author root
 */
public interface RegistreDeNaissanceDAO extends GenericDAO<RegistreDeNaissance, String>{
   Optional<RegistreDeNaissance> findByReference(ReferenceRegistre reference);
}
