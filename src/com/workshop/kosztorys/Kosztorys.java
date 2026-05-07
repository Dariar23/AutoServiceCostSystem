package com.workshop.kosztorys;

import com.workshop.uslugi.myUsluga;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Kosztorys {
    private int kosztorysId;
    private LocalDate dataWystawienia;
    private float rabatProcentowy;
    private Float kosztCalkowity;
    private String status;
    private List<myUsluga> listaUslug;

    public Kosztorys(int kosztorysId, LocalDate dataWystawienia) {
        this.kosztorysId = kosztorysId;
        this.dataWystawienia = dataWystawienia;
        this.rabatProcentowy = 0;
        this.kosztCalkowity = null;
        this.status = "nowy";
        this.listaUslug = new ArrayList<>();
    }

    public void dodajUsluge(myUsluga usluga) {
        listaUslug.add(usluga);
        kosztCalkowity = null; 
    }

    public void obliczKosztCalkowity() {
        float suma = 0;
        for (myUsluga u : listaUslug) {
            suma += u.obliczKoszt();
        }
        this.kosztCalkowity = suma;
    }

    public void zastosujRabat(float rabatProcent) {
        this.rabatProcentowy = rabatProcent;
        if (kosztCalkowity != null) {
            float kwotaRabatu = kosztCalkowity * (rabatProcent / 100);
            this.kosztCalkowity = kosztCalkowity - kwotaRabatu;
        }
    }

    public Float getKosztCalkowity() {
        if (kosztCalkowity == null) {
            obliczKosztCalkowity();
        }
        return kosztCalkowity;
    }

    // gettery i settery
    public int getKosztorysId() { return kosztorysId; }
    public LocalDate getDataWystawienia() { return dataWystawienia; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public List<myUsluga> getListaUslug() { return listaUslug; }
}