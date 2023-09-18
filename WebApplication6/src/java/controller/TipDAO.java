package controller;



//package br.com.controleFinanceiro.controller;
import java.util.List;


import pojo.Tip;

public interface TipDAO {

    
    public void persist(Tip tip);

    public Tip getById(final int id);

    public List<Tip> findAll();

    public void remove(Tip tip);

    public void merge(Tip tip);


}
