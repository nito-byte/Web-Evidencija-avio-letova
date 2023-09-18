/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.List;
import pojo.*;

/**
 *
 * @author tijana
 */
public interface AzuriranjeDAO {
    
      public void persist(Azuriranje azuriranje);

    public Azuriranje getById(final int id);

    public List<Azuriranje> findAll();

    public void remove(Azuriranje azuriranje);

    public void merge(Azuriranje azuriranje);
    
}
