package modell;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Galeria implements Iterable<KiallitasiTargy>, Serializable {

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
    
    public void cimRendez(){
        Collections.sort(targyak, KiallitasiTargy.CimRendezo());
    }
    
    public void keszitoRendez(){
        Collections.sort(targyak);
    }

    @Override
    public Iterator<KiallitasiTargy> iterator() {
        return targyak.iterator();
    }
    
    public void kiir(){
        try (ObjectOutputStream objKi = new ObjectOutputStream(new FileOutputStream("galeria.bin"))) {
            objKi.writeObject(this);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static Galeria beolvas(String fajlNev){
        Galeria galeria = new Galeria();
        try(ObjectInputStream objBe = new ObjectInputStream(new FileInputStream(fajlNev))){
            galeria = (Galeria)objBe.readObject();           
            return galeria;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return galeria;
    }
    
}
