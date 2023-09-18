/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flight.jsf.avion;

import java.util.List;
import pojo.Airplane;

/**
 *
 * @author tijana
 */
public interface AirplaneDAO {
    
    public void persist(Airplane airplane);
       

    public Airplane getById(final int id) ;
    public List<Airplane> findAll();
      

    public void remove(Airplane airplane) ;
      
    public void merge(Airplane airplane) ;
        
    
}
