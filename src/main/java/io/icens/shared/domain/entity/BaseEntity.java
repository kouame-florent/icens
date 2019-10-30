/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.shared.domain.entity;


import io.icens.shared.interfaces.Editable;
import io.icens.shared.interfaces.Identifiable;
import io.icens.shared.interfaces.Timestampable;
import io.icens.shared.interfaces.Versionable;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.persistence.Version;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 *
 * @author root
 */
@MappedSuperclass
@EqualsAndHashCode
@ToString
public abstract class BaseEntity implements Identifiable, Editable,
        Timestampable, Versionable, Serializable{
    
    @Column(length = 100)
    @Getter @Setter
    @Id 
    protected String uuid = UUID.randomUUID().toString();
    
    @Getter
    @EqualsAndHashCode.Exclude
    private final LocalDateTime created = LocalDateTime.now();
    
    @Getter
    @EqualsAndHashCode.Exclude
    private final LocalDateTime updated = LocalDateTime.now();
    
    @Getter @Setter
    @Transient
    protected boolean edited = false;
    
    @Getter
    @EqualsAndHashCode.Exclude
    @Version
    protected long version;
}
