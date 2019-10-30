/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.icens.shared.interfaces;

import java.time.LocalDateTime;

/**
 *
 * @author root
 */
public interface Timestampable {
    LocalDateTime getCreated();
    LocalDateTime getUpdated();
}
