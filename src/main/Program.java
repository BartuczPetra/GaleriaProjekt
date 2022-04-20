package main;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;
import modell.Festmeny;
import modell.Galeria;
import modell.KiallitasiTargy;

public class Program {

    public static void main(String[] args) {
        Galeria galeria=new Galeria();
        galeria.felvesz(new Festmeny("AFestő1", "JCim1"));
        galeria.felvesz(new Festmeny(LocalDate.now(), "Festő2", "Cim2"));
        //galeria.felvesz(new Festmeny(LocalDate.of(2022, Month.AUGUST, 11), "Festő3", "Cim3"));
        galeria.felvesz(new Festmeny("HFestő4", "ACím4", "kep.txt"));
        galeria.felvesz(new Festmeny(LocalDate.now(), "BFestő5", "KCím5", "kep.txt"));
        
        galeria.cimRendez();
        for (KiallitasiTargy kiallitasiTargy : galeria) {
            System.out.println(kiallitasiTargy);
        }
        System.out.println("");
        galeria.keszitoRendez();
        for (KiallitasiTargy kiallitasiTargy : galeria) {
            System.out.println(kiallitasiTargy);
        }
    }
    
}
