package com.workshop.model;

public class PozycjaCzesci {
    private String nazwaCzesci;
    private int ilosc;
    private double cenaJednostkowa;

    public PozycjaCzesci(String nazwaCzesci, int ilosc, double cenaJednostkowa) {
        
        this.nazwaCzesci = nazwaCzesci;
        this.ilosc = ilosc;
        this.cenaJednostkowa = cenaJednostkowa;
    }

    public double getKosztCalkowity() {
        return ilosc * cenaJednostkowa;
    }
}