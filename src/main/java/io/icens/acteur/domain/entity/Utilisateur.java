/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.acteur.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author root
 */
@Table(name = "IC_UTILISATEUR",
        uniqueConstraints = @UniqueConstraint(name = "UNQ_LOGIN",columnNames = {"login"})
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
public class Utilisateur extends BaseEntity{
    
    @Column(name = "login")
    @Getter @Setter
    @Email
    private String login;
    
    @Column(name = "password")
    @Getter @Setter
    @Min(4) @Max(30)
    private String password;
}
