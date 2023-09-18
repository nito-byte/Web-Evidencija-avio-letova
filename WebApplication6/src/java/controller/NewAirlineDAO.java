/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import pojo.Airline;

/**
 *
 * @author tijana
 */
public interface NewAirlineDAO {

    public void persist(Airline airline);

    public Airline getById(final int id);
    public Airline getByName(final String name);

    public List<Airline> findAll();
    
    public List<Airline> findAllAirline(String airline);

    public void remove(Airline airline);

    public void merge(Airline airline);

}
