package appModels;

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

    public Gemeente(String naam, int aantalBewoners) {
        this.setNaam(naam);
        this.setAantalBewoners(aantalBewoners);
    }

    public boolean bestaatAZC(String straatnaam) {

        for (AZC a : this.localeAZCS) {

            if (straatnaam.equalsIgnoreCase(a.getStraatnaam())) {
                System.out.println("Dis AZC bestaat al in deze gemeente.");
                return true;
            }
        }
        return false;
    }

    public void voegAZCToe(AZC azc) {
        this.localeAZCS.add(azc);
    }
}
