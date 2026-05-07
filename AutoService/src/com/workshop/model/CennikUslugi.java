package com.workshop.model;

import com.workshop.uslugi.myUsluga;

public class CennikUslugi {
    private int cennikId;
    private ModelPojazdu model;
    private myUsluga usluga;
    private double cena;
    private String waluta;

    public CennikUslugi(int cennikId, ModelPojazdu model, myUsluga usluga, double cena, String waluta) {
        this.cennikId = cennikId;
        this.model = model;
        this.usluga = usluga;
        this.cena = cena;
        this.waluta = waluta;
    }

    public double pobierzCene() {
        return cena;
    }

    public ModelPojazdu getModel() { 
        return model; 
    }
    public myUsluga getUsluga() { 
        return usluga; 
    }
}