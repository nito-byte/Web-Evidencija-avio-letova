package com.flight.jsf.proizvodjac;



//package br.com.controleFinanceiro.controller;
import java.util.List;



import pojo.Proizvodjac;

public interface ProizvodjacDAO {

    public void persist(Proizvodjac proizvodjac);

    public Proizvodjac getById(final int id);

    public List<Proizvodjac> findAll();

    public void remove(Proizvodjac proizvodjac);

    public void merge(Proizvodjac proizvodjac);

}
