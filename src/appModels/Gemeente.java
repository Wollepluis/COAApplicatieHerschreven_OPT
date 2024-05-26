package appModels;

import utils.Gemeente_Controller;

import java.util.ArrayList;

public class Gemeente {

    private String naam;
    private int aantalBewoners;

    private final ArrayList<AZC> localeAZCS = new ArrayList<>();

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setAantalBewoners(int aantalBewoners) {
        this.aantalBewoners = aantalBewoners;
    }

    public String getNaam() {
        return this.naam;
    }

    public int getAantalBewoners() {
        return this.aantalBewoners;
    }

    public ArrayList<AZC> getLocaleAZCS() {
        return this.localeAZCS;
    }

    public Gemeente(String naam, int aantalBewoners) {
        this.setNaam(naam);
        this.setAantalBewoners(aantalBewoners);
    }
}
