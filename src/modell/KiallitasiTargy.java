package modell;

import java.text.Collator;
import java.time.LocalDate;
import java.util.Comparator;

class CimComparator implements Comparator<KiallitasiTargy> {

    @Override
    public int compare(KiallitasiTargy egyik, KiallitasiTargy masik) {
        Collator col = Collator.getInstance();
        return col.compare(egyik.getCim(), masik.getCim());
    }
}

public abstract class KiallitasiTargy implements Comparable<KiallitasiTargy>{
    private LocalDate letrehozasiDatum;
    private String keszito, cim;
    
    public static CimComparator CimRendezo() {
        return new CimComparator();
    }

    public KiallitasiTargy(String keszito, String cim) {
        this(LocalDate.now(), keszito, cim);
    }
    
    public KiallitasiTargy(LocalDate letrehozasiDatum, String keszito, String cim) {
        this.letrehozasiDatum = letrehozasiDatum;
        this.keszito = keszito;
        this.cim = cim;
        if(this.letrehozasiDatum.isAfter(LocalDate.now())){
            throw new ArithmeticException("A dátum nem lehet jövőbeli dátum.");
        }
    }
    
    public String getCim() {
        return cim;
    }

    public String getKeszito() {
        return keszito;
    }

    public LocalDate getLetrehozasiDatum() {
        return letrehozasiDatum;
    }
    

    @Override
    public abstract int compareTo(KiallitasiTargy masik);

    @Override
    public abstract String toString();
    
    
}
