package modell;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Galeria implements Iterable<KiallitasiTargy> {

    private ArrayList<KiallitasiTargy> targyak;

    public Galeria() {
        targyak = new ArrayList<>();
    }

    public List<KiallitasiTargy> getTargyak() {
        return Collections.unmodifiableList(targyak);
    }

    public void felvesz(KiallitasiTargy targy) {
        try {
            targyak.add(targy);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public Iterator<KiallitasiTargy> iterator() {
        return targyak.iterator();
    }
}
