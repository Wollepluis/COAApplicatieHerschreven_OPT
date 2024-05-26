package utils;

import appModels.AZC;
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

    public Gemeente getGemeente(String name) {

        for (Gemeente g : this.alleGemeentes) {

            if (name.equalsIgnoreCase(g.getNaam())) {
                return g;
            }
        }
        return null;
    }

    public void voegGemeenteToe(Gemeente gemeente) {
        this.alleGemeentes.add(gemeente);
    }

    public void voegLokaalAZCToe(Gemeente gemeente, AZC azc) {
        gemeente.getLocaleAZCS().add(azc);
    }

    public void verwijderLokaalAZC(Gemeente gemeente, AZC azc) {
        gemeente.getLocaleAZCS().remove(azc);
    }
}
