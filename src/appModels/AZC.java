package appModels;

import userClasses.Vluchteling;

import java.util.ArrayList;

public class AZC {

    private Gemeente gemeente;
    private String postcode;
    private String straatnaam;
    private int huisnummer;
    private int aantalPlaatsen;

    private ArrayList<Vluchteling> gevestigdeVluchtelingen;

    public void setGemeente(Gemeente gemeente) {
        this.gemeente = gemeente;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setStraatnaam(String straatnaam) {
        this.straatnaam = straatnaam;
    }

    public void setHuisnummer(int huisnummer) {
        this.huisnummer = huisnummer;
    }

    public void setAantalPlaatsen(int aantalPlaatsen) {
        this.aantalPlaatsen = aantalPlaatsen;
    }

    public String getGemeente() {
        return this.gemeente.getNaam();
    }

    public String getPostcode() {
        return this.postcode;
    }

    public String getStraatnaam() {
        return this.straatnaam;
    }

    public int getHuisnummer() {
        return this.huisnummer;
    }

    public int getAantalPlaatsen() {
        return this.aantalPlaatsen;
    }

    public AZC(Gemeente gemeente, String postcode, String straatnaam, int huisnummer, int aantalPlaatsen) {
        this.setGemeente(gemeente);
        this.setPostcode(postcode);
        this.setStraatnaam(straatnaam);
        this.setHuisnummer(huisnummer);
        this.setAantalPlaatsen(aantalPlaatsen);
        this.gevestigdeVluchtelingen  = new ArrayList<>();
    }
}
