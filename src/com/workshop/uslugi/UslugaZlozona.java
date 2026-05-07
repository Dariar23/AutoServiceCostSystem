package com.workshop.uslugi;

import com.workshop.model.ModelPojazdu;
import com.workshop.model.StanowiskoNaprawcze;
import java.util.ArrayList;
import java.util.List;

public class UslugaZlozona implements myUsluga {
    private String nazwa;
    private String opis;
    private List<myUsluga> poduslugi;

    public UslugaZlozona(String nazwa, String opis) {
        this.nazwa = nazwa;
        this.opis = opis;
        this.poduslugi = new ArrayList<>();
    }

    public void dodajUsluge(myUsluga usluga) {
        poduslugi.add(usluga);
    }

    public void usunUsluge(myUsluga usluga) {
        poduslugi.remove(usluga);
    }

    @Override
    public float obliczKoszt() {
        return (float) poduslugi.stream().mapToDouble(myUsluga::obliczKoszt).sum();
    }

    @Override
    public String getOpis() {
        return opis;
    }

    @Override
    public List<ModelPojazdu> getModelePojazdu() {
        List<ModelPojazdu> wszystkie = new ArrayList<>();
        for (myUsluga u : poduslugi) {
            wszystkie.addAll(u.getModelePojazdu());
        }
        return wszystkie;
    }

    @Override
    public int getCzasSzacunkowy() {
        return poduslugi.stream().mapToInt(myUsluga::getCzasSzacunkowy).sum();
    }

    @Override
    public List<StanowiskoNaprawcze> getStanowiska() {
        List<StanowiskoNaprawcze> wszystkie = new ArrayList<>();
        for(myUsluga u : poduslugi) {
            wszystkie.addAll(u.getStanowiska());
        }
        return wszystkie;
    }

    public String getNazwa() { 
        return nazwa; 
    }
}