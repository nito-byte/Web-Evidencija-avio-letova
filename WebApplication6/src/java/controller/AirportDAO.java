package controller;



//package br.com.controleFinanceiro.controller;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pojo.Airport;

public interface AirportDAO {

    
    public void persist(Airport airport);

    public Airport getById(final int id);

    public List<Airport> findAll();

    public void remove(Airport airport);

    public void merge(Airport airport);


}
