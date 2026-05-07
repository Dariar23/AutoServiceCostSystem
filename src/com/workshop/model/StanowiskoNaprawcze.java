package com.workshop.model;

public class StanowiskoNaprawcze {
    private int stanowiskoId;
    private String nazwa;
    private double stawkaGodzinowa;

    public StanowiskoNaprawcze(int stanowiskoId, String nazwa, double stawkaGodzinowa) {
        this.stanowiskoId = stanowiskoId;
        this.nazwa = nazwa;
        this.stawkaGodzinowa = stawkaGodzinowa;
    }

    public double getStawkaGodzinowa() { 
        return stawkaGodzinowa; 
    }
    public String getNazwa() { 
        return nazwa; 
    }
}