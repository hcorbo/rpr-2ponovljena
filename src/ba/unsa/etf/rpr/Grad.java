package ba.unsa.etf.rpr;

import java.io.Serializable;

public class Grad implements Serializable
{
    //ATRIBUTI
    private int id;
    private String naziv;
    private int brojStanovnika;
    private Drzava drzava;
    private int zagadjenost = 1;

    public Grad(int id, String naziv, int brojStanovnika, Drzava drzava, int zagadjenost) {
        this.id = id;
        this.naziv = naziv;
        this.brojStanovnika = brojStanovnika;
        this.drzava = drzava;

        if(zagadjenost > 10 || zagadjenost < 1)
            throw new IllegalArgumentException();

        this.zagadjenost = zagadjenost;
    }

    public Grad() {
    }

    //GETTERI I SETTERI
    public int getZagadjenost()
    {
        if(zagadjenost > 10 || zagadjenost < 1)
            throw new IllegalArgumentException();

        return zagadjenost;
    }

    public void setZagadjenost(int zagadjenost)
    {
        if(zagadjenost > 10 || zagadjenost < 1)
            throw new IllegalArgumentException();

        this.zagadjenost = zagadjenost;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getBrojStanovnika() {
        return brojStanovnika;
    }

    public void setBrojStanovnika(int brojStanovnika) {
        this.brojStanovnika = brojStanovnika;
    }

    public Drzava getDrzava() {
        return drzava;
    }

    public void setDrzava(Drzava drzava) {
        this.drzava = drzava;
    }

    @Override
    public String toString() { return naziv; }
}
