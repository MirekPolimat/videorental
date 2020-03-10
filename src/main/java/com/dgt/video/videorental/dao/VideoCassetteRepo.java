/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgt.video.videorental.dao;

import com.dgt.video.videorental.dao.entity.VideoCassette;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author miroslawk
 */
@Repository
public interface VideoCassetteRepo extends CrudRepository<VideoCassette, Long>{
    
}
