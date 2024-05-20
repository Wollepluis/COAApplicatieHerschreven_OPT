package appModels;

import java.util.ArrayList;

public class LocalAuthority {

    private String name;
    private int population;

    private static final ArrayList<LocalAuthority> allLocalAuthorities = new ArrayList<>();
    private final ArrayList<AsylumCentre> localAsylumCentres = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getName() {
        return this.name;
    }

    public int getPopulation() {
        return this.population;
    }

    public LocalAuthority(String name, int population) {
        this.setName(name);
        this.setPopulation(population);
    }

    public static LocalAuthority getLocalAuthority(String name) {

        for (LocalAuthority l : allLocalAuthorities) {

            if(name.equalsIgnoreCase(l.getName())) {
                return l;
            }
        }
        return null;
    }

    public void addAsylumCentre(AsylumCentre asylumCentre) {
        localAsylumCentres.add(asylumCentre);
    }

    public boolean hasAsylumCentre(String streetName) {

        for (AsylumCentre a : localAsylumCentres) {

            if (streetName.equalsIgnoreCase(a.getStreetName())) {
                System.out.println("This asylum centre is already registered.");
                return true;
            }
        }
        return false;
    }
}
