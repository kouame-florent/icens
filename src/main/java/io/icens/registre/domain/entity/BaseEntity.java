/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.registre.domain.entity;

import io.icens.registre.domain.interfaces.Editable;
import io.icens.registre.domain.interfaces.Identifiable;
import io.icens.registre.domain.interfaces.Timestampable;
import io.icens.registre.domain.interfaces.Versionable;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.persistence.Version;
import lombok.Getter;
import lombok.Setter;


/**
 *
 * @author root
 */
@MappedSuperclass
public abstract class BaseEntity implements Identifiable, Editable,
        Timestampable, Versionable, Serializable{
    
    @Column(length = 100)
    @Id @Getter @Setter
    protected String uuid = UUID.randomUUID().toString();
    
    @Getter
    private final LocalDateTime created = LocalDateTime.now();
    
    @Getter
    private final LocalDateTime updated = LocalDateTime.now();
    
    @Getter @Setter
    @Transient
    protected boolean edited = false;
    
    @Getter
    @Version
    protected long version;
}
