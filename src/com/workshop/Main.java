package com.workshop;

import com.workshop.kosztorys.Kosztorys;
import com.workshop.model.ModelPojazdu;
import com.workshop.model.PozycjaCzesci;
import com.workshop.model.StanowiskoNaprawcze;
import com.workshop.uslugi.UslugaProsta;
import com.workshop.uslugi.UslugaZlozona;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        
        // Tworzę kilka modeli samochodów
        ModelPojazdu audi = new ModelPojazdu(1, "Audi", "A4");
        ModelPojazdu bmw = new ModelPojazdu(2, "BMW", "X5");
        
        // Stanowiska w warsztacie
        StanowiskoNaprawcze stanMechanika = new StanowiskoNaprawcze(1, "Stanowisko mechaniczne", 100);
        StanowiskoNaprawcze stanElektryka = new StanowiskoNaprawcze(2, "Stanowisko elektryczne", 130);
        
        // Usługa prosta - wymiana oleju
        UslugaProsta olej = new UslugaProsta(1, "Wymiana oleju", "Wymiana oleju silnikowego", 120, 30);
        olej.dodajModel(audi);
        olej.dodajModel(bmw);
        olej.dodajStanowisko(stanMechanika);
        
        // Usługa prosta - diagnostyka
        UslugaProsta diag = new UslugaProsta(2, "Diagnostyka", "Sprawdzenie komputera", 150, 20);
        diag.dodajModel(audi);
        diag.dodajStanowisko(stanElektryka);
        
        // Dodaję część do diagnostyki (kabel)
        PozycjaCzesci kabel = new PozycjaCzesci("Kabel diagnostyczny", 1, 50);
        diag.dodajCzesc(kabel);
        
        // Tworzę pakiet usług (złożona usługa)
        UslugaZlozona pakiet = new UslugaZlozona("Pakiet serwisowy", "Olej + diagnostyka");
        pakiet.dodajUsluge(olej);
        pakiet.dodajUsluge(diag);
        
        // Tworzę kosztorys i dodaję usługi
        Kosztorys koszt = new Kosztorys(1, LocalDate.now());
        koszt.dodajUsluge(olej);
        koszt.dodajUsluge(pakiet);
        
        // Wyświetlam wyniki
        System.out.println("KOSZTORYS NR " + koszt.getKosztorysId());
        System.out.println("Data: " + koszt.getDataWystawienia());
        System.out.println("----------------");
        
        System.out.println("1. " + olej.getNazwa() + " = " + olej.obliczKoszt() + " zł");
        System.out.println("2. " + pakiet.getNazwa() + " = " + pakiet.obliczKoszt() + " zł");
        
        System.out.println("----------------");
        System.out.println("SUMA: " + koszt.getKosztCalkowity() + " zł");
        
        // Dodaję rabat 10%
        koszt.zastosujRabat(10);
        System.out.println("Po rabacie 10%: " + koszt.getKosztCalkowity() + " zł");
        
        // Sprawdzam ile czasu zajmie pakiet
        System.out.println("Czas pakietu: " + pakiet.getCzasSzacunkowy() + " minut");
    }
}