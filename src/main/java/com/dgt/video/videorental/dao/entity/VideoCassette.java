/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgt.video.videorental.dao.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author miroslawk
 */

@Entity
public class VideoCassette {
    private long id;
    private String title;
    private LocalDate productionYear;

    public VideoCassette() {
    }

//    public VideoCassette(long id, String title, LocalDate productionYear) {
//        this.id = id;
//        this.title = title;
//        this.productionYear = productionYear;
//    }
    
    public VideoCassette(String title, LocalDate productionYear) {
        this.title = title;
        this.productionYear = productionYear;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(LocalDate productionYear) {
        this.productionYear = productionYear;
    }
    
}
