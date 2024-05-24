package utils;

import appModels.Gemeente;

import java.util.ArrayList;

public class Gemeente_Controller {

    private static Gemeente_Controller instance = null;
    private final ArrayList<Gemeente> alleGemeentes;

    public static Gemeente_Controller getInstance() {

        if (instance == null) {
            instance = new Gemeente_Controller();
        }
        return instance;
    }

    public ArrayList<Gemeente> getAlleGemeentes() {
        return this.alleGemeentes;
    }

    public Gemeente_Controller() {
        this.alleGemeentes = new ArrayList<>();
    }

    public boolean GemeenteBestaat(String name) {

        for (Gemeente g : alleGemeentes) {

            if (name.equalsIgnoreCase(g.getNaam())) {
                System.out.println("Deze gemeente is al geregistreerd.");
                return true;
            }
        }
        return false;
    }

    public void voegGemeenteToe(Gemeente gemeente) {
        alleGemeentes.add(gemeente);
    }
}
