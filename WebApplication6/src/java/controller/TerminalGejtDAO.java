package controller;



//package br.com.controleFinanceiro.controller;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pojo.TerminalGejt;

public interface TerminalGejtDAO {

    
    public void persist(TerminalGejt terminalGejt);

    public TerminalGejt getById(final int id);

    public List<TerminalGejt> findAll();

    public void remove(TerminalGejt terminalGejt);

    public void merge(TerminalGejt terminalGejt);


}
