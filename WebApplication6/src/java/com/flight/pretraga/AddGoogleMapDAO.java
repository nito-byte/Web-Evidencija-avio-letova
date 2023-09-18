package com.flight.pretraga;

import java.util.List;
import pojo.RadarCentar;


public interface AddGoogleMapDAO {
    

    public void persist(RadarCentar radarCentar); 

    public List<RadarCentar> findAll();

    public void remove(RadarCentar  radarCentar);

    public void merge(RadarCentar radarCentar);

    public List<RadarCentar> getBrojLeta(String brojLeta);
    
}
