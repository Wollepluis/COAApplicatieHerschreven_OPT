package appModels;

import java.util.ArrayList;

public class Gemeente {

    private String naam;
    private int aantalInwoners;

    private final ArrayList<AZC> localeAZCS = new ArrayList<>();

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setAantalInwoners(int aantalInwoners) {
        this.aantalInwoners = aantalInwoners;
    }

    public String getNaam() {
        return this.naam;
    }

    public int getAantalInwoners() {
        return this.aantalInwoners;
    }

    public ArrayList<AZC> getLocaleAZCS() {
        return this.localeAZCS;
    }

    public Gemeente(String naam, int aantalInwoners) {
        this.setNaam(naam);
        this.setAantalInwoners(aantalInwoners);
    }
}
