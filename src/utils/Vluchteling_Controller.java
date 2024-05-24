package utils;

import userClasses.Vluchteling;

import java.util.ArrayList;

public class Vluchteling_Controller {

    private static Vluchteling_Controller instance = null;

    private final ArrayList<Vluchteling> nieuweVluchtelingen;
    private final ArrayList<Vluchteling> geregistreerdeVluchtelingen;

    public static Vluchteling_Controller getInstance() {

        if (instance == null) {
            instance = new Vluchteling_Controller();
        }
        return instance;
    }

    public ArrayList<Vluchteling> getLijstNieuweVluchtelingen() {
        return this.nieuweVluchtelingen;
    }

    public ArrayList<Vluchteling> getLijstGeregistreerdeVluchtelingen() {
        return this.geregistreerdeVluchtelingen;
    }

    public Vluchteling getNieuweVluchteling(String naam) {

        for (Vluchteling r : this.nieuweVluchtelingen) {

            if (naam.equalsIgnoreCase(r.getNaam())) {
                return r;
            }
        }
        return null;
    }

    public Vluchteling getGeregistreerdeVluchteling(String naam) {

        for (Vluchteling v : this.geregistreerdeVluchtelingen) {

            if (naam.equalsIgnoreCase(v.getNaam())) {
                return v;
            }
        }
        return null;
    }

    public Vluchteling_Controller() {
        this.nieuweVluchtelingen = new ArrayList<>();
        this.geregistreerdeVluchtelingen = new ArrayList<>();
    }

    public int checkRegistratie(String naam) {

        for (Vluchteling v : this.geregistreerdeVluchtelingen) {

            if (naam.equalsIgnoreCase(v.getNaam())) {
                return 1;
            }
        }

        for (Vluchteling v : this.nieuweVluchtelingen) {

            if (naam.equalsIgnoreCase(v.getNaam())) {
                return 2;
            }
        }
        return 0;
    }

    public void voegNieuweVluchtelingToe(Vluchteling vluchteling) {
        this.nieuweVluchtelingen.add(vluchteling);
    }

    public void registreerVluchteling(String naam) {

        for (Vluchteling v : this.nieuweVluchtelingen) {

            if (naam.equalsIgnoreCase(v.getNaam())) {
                this.geregistreerdeVluchtelingen.add(v);
                this.nieuweVluchtelingen.remove(v);
            }
        }
    }
}
