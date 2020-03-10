/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgt.video.videorental.manager;

import com.dgt.video.videorental.dao.VideoCassetteRepo;
import com.dgt.video.videorental.dao.entity.VideoCassette;
import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 *
 * @author miroslawk
 */
@Service
public class VideoCassetteManager {
    private VideoCassetteRepo videocassetRep;
    
    @Autowired
    public VideoCassetteManager(VideoCassetteRepo videocassetRep) {
        this.videocassetRep = videocassetRep;
    }
    public Optional<VideoCassette> findById(long id){
        return videocassetRep.findById(id);
    }

    public Iterable<VideoCassette> findAll(){
        return videocassetRep.findAll();
    }
    public VideoCassette save (VideoCassette videoCassette){
        return videocassetRep.save(videoCassette);
    }
    public void deleteById(long id){
        videocassetRep.deleteById(id);
    }
    @EventListener(ApplicationReadyEvent.class)
    public void fillDb(){
       save(new VideoCassette("Titanic", LocalDate.of(1995, Month.MARCH, 1)));
       save(new VideoCassette("Pulp Fiction", LocalDate.of(1990, Month.MAY, 12)));
    }
 
}
