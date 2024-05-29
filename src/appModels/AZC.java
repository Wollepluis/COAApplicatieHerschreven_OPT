package appModels;

import userClasses.Vluchteling;

import java.util.ArrayList;

public class AZC {

    private Gemeente gemeente;
    Adres adres;
    private int aantalPlaatsen;

    public ArrayList<Vluchteling> gevestigdeVluchtelingen;

    public void setGemeente(Gemeente gemeente) {
        this.gemeente = gemeente;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public void setAantalPlaatsen(int aantalPlaatsen) {
        this.aantalPlaatsen = aantalPlaatsen;
    }

    public String getGemeente() {
        return this.gemeente.getNaam();
    }

    public Adres getAdres() {
        return this.adres;
    }

    public int getAantalPlaatsen() {
        return this.aantalPlaatsen;
    }

    public AZC(Gemeente gemeente, Adres adres, int aantalPlaatsen) {
        this.setGemeente(gemeente);
        this.setAdres(adres);
        this.setAantalPlaatsen(aantalPlaatsen);
        this.gevestigdeVluchtelingen  = new ArrayList<>();
    }
}
