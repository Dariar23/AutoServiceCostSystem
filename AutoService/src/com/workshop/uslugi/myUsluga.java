package com.workshop.uslugi;

import com.workshop.model.ModelPojazdu;
import com.workshop.model.StanowiskoNaprawcze;
import java.util.List;

public interface myUsluga {

    float obliczKoszt();
    String getOpis();
    List<ModelPojazdu> getModelePojazdu();
    int getCzasSzacunkowy();
    List<StanowiskoNaprawcze> getStanowiska();
    
}