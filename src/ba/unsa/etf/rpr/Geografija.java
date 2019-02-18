package ba.unsa.etf.rpr;

import java.io.Serializable;
import java.util.ArrayList;

public class Geografija implements Serializable
{
   //ATRIBUTI
    ArrayList<Grad> gradovi = new ArrayList<>();
    ArrayList<Drzava> drzave = new ArrayList<>();

    GeografijaDAO gdo;

    //KONSTRUKTOR
    public Geografija()
    {}

    //GETTERI I SETTERI
    public ArrayList<Grad> getGradovi() {
        return gradovi;
    }

    public void setGradovi(ArrayList<Grad> gradovi) {
        this.gradovi = gradovi;
    }

    public ArrayList<Drzava> getDrzave() {
        return drzave;
    }

    public void setDrzave(ArrayList<Drzava> drzave) {
        this.drzave = drzave;
    }



    //METODE
}
