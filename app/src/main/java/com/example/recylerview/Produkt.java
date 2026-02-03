package com.example.recylerview;

public class Produkt {
    private String nazwa;
    private boolean czyKupione;

    private double cena;

    public Produkt(String nazwa, double cena) {
        this.nazwa = nazwa;
        this.cena = cena;
        czyKupione = false;
    }

    public String getNazwa() {
        return nazwa;
    }

    public boolean isCzyKupione() {
        return czyKupione;
    }

    public double getCena() {
        return cena;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setCzyKupione(boolean czyKupione) {
        this.czyKupione = czyKupione;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "Produkt{" +
                "nazwa='" + nazwa + '\'' +
                ", czyKupione=" + czyKupione +
                ", cena=" + cena +
                '}';
    }
}
