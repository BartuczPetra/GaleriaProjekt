package modell;

import java.io.File;
import java.time.LocalDate;

public class Festmeny extends KiallitasiTargy{
    private String fajl;

    public Festmeny(String keszito, String cim, String fajl) {
        super(keszito, cim);
        this.fajl=fajl;
    }
    
    public Festmeny(LocalDate letrehozasiDatum, String keszito, String cim, String fajl) {
        super(letrehozasiDatum, keszito, cim);
        this.fajl=fajl;
    }

    
    public void megjelenites(){
        File f = new File(fajl);
        if(f.exists()){
            System.out.println("megjelenítés folyamatban...");
        }else{
            System.out.println("nem lehet megjeleníteni!");
        }
    }
    
    
}
