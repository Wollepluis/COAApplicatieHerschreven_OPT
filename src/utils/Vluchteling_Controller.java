package utils;

import userClasses.Vluchteling;

import java.util.ArrayList;

public class Vluchteling_Controller {

    private static Vluchteling_Controller instance = null;

    private final ArrayList<Vluchteling> alleVluchtelingen;

    public static Vluchteling_Controller getInstance() {

        if (instance == null) {
            instance = new Vluchteling_Controller();
        }
        return instance;
    }

    public ArrayList<Vluchteling> getAlleVluchtelingen() {
        return this.alleVluchtelingen;
    }

    public Vluchteling_Controller() {
        this.alleVluchtelingen = new ArrayList<>();
    }

    public boolean checkRegistratie(Vluchteling vluchteling) {
        return vluchteling.isGeregistreerd();
    }

    public void registreerVluchteling(Vluchteling vluchteling) {
        vluchteling.setGeregistreerd(true);
    }
}
