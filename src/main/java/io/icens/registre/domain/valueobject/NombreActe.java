/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.registre.domain.valueobject;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author root
 */
@Embeddable
public class NombreActe implements Serializable {
    @Getter @Setter
    @Column(name = "nombre_acte")
    long nombreActe;
}
