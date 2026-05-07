package com.workshop.uslugi;

import com.workshop.model.ModelPojazdu;
import com.workshop.model.PozycjaCzesci;
import com.workshop.model.StanowiskoNaprawcze;
import java.util.ArrayList;
import java.util.List;

public class UslugaProsta implements myUsluga {
    private int uslugaId;
    private String nazwa;
    private String opis;
    private float kosztRobocizny;
    private int czasSzacunkowy;
    private List<ModelPojazdu> modele;
    private List<StanowiskoNaprawcze> stanowiska;
    private List<PozycjaCzesci> czesci;

    public UslugaProsta(int uslugaId, String nazwa, String opis, float kosztRobocizny, int czasSzacunkowy) {
        this.uslugaId = uslugaId;
        this.nazwa = nazwa;
        this.opis = opis;
        this.kosztRobocizny = kosztRobocizny;
        this.czasSzacunkowy = czasSzacunkowy;
        this.modele = new ArrayList<>();
        this.stanowiska = new ArrayList<>();
        this.czesci = new ArrayList<>();
    }

    @Override
    public float obliczKoszt() {
        float kosztCzesci = (float) czesci.stream().mapToDouble(PozycjaCzesci::getKosztCalkowity).sum();
        return kosztRobocizny + kosztCzesci;
    }

    @Override
    public String getOpis() {
        return opis;
    }

    public void dodajCzesc(PozycjaCzesci p) {
        czesci.add(p);
    }

    public void usunCzesc(PozycjaCzesci p) {
        czesci.remove(p);
    }

    @Override
    public List<ModelPojazdu> getModelePojazdu() {
        return new ArrayList<>(modele);
    }

    @Override
    public int getCzasSzacunkowy() {
        return czasSzacunkowy;
    }

    @Override
    public List<StanowiskoNaprawcze> getStanowiska() {
        return new ArrayList<>(stanowiska);
    }

    public void dodajModel(ModelPojazdu m) { 
        modele.add(m); 
    }
    public void dodajStanowisko(StanowiskoNaprawcze s) { 
        stanowiska.add(s); 
    }
    public String getNazwa() { 
        return nazwa; 
    }
}