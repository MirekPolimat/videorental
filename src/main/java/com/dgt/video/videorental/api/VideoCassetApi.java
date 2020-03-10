/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgt.video.videorental.api;

import com.dgt.video.videorental.dao.entity.VideoCassette;
import com.dgt.video.videorental.manager.VideoCassetteManager;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author miroslawk
 */
@RestController
@RequestMapping("/api/cassets")
public class VideoCassetApi {
    
//    
//    private List<VideoCassette> videoCassetts;
//
//    public VideoCassetApi() {
//        videoCassetts=new ArrayList<>();
//        videoCassetts.add(new VideoCassette(1L, "Titanic", LocalDate.of(1995, Month.MARCH, 1)));
//        videoCassetts.add(new VideoCassette(2L, "Pulp Fiction", LocalDate.of(1990, Month.MAY, 12)));
    
    
private VideoCassetteManager videoCassetteManager;
    @Autowired
    public VideoCassetApi(VideoCassetteManager videoCassetteManager) {
        this.videoCassetteManager = videoCassetteManager;
    }

    
    @GetMapping("/all")
    public Iterable<VideoCassette> getAllCassetts(){
        return videoCassetteManager.findAll();
    }
    @GetMapping
    public Optional<VideoCassette> getById(@RequestParam int id){
          return videoCassetteManager.findById(id);
//        Optional<VideoCassette> casset=videoCassetts.sream().filter(element-> element.getId()==id).findFirst();
//        return casset.get();
    }
    @PostMapping
    public VideoCassette addCassett(@RequestBody VideoCassette casset){
       return  videoCassetteManager.save(casset);
        
//        return videoCassetts.add(casset);
    }
    @PutMapping
    public VideoCassette uptadeCassett(@RequestBody VideoCassette casset){
        long ind=casset.getId();
//        Optional<VideoCassette> cassetFirst=videoCassetts.stream().filter(element-> element.getId()==ind).findFirst();
        Optional<VideoCassette> cassetFirst =videoCassetteManager.findById(ind);
        if(cassetFirst.isPresent()){
            videoCassetteManager.deleteById(cassetFirst.get().getId());
//            videoCassetts.remove(cassetFirst.get());

//            return videoCassetts.add(casset);     
//            return true;
        }
//           return false;
        return videoCassetteManager.save(casset);
    }
    
    
    @DeleteMapping
    public void deleteCassett(@RequestParam int id){
//        return videoCassetts.removeIf(element-> element.getId()==id);
    videoCassetteManager.deleteById(id);
    }
    
    
}
