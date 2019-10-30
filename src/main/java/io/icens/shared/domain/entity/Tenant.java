/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.shared.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author root
 */
@Table(name = "IC_TENANT")
@Getter @Setter
@Entity
public class Tenant extends BaseEntity{
        
    @Column(name = "name")
    private String name;
        
    @Column(name = "description")
    private String description;
}
