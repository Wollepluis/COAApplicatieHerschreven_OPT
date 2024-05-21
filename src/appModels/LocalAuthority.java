package appModels;

import java.util.ArrayList;

public class LocalAuthority {

    private String name;
    private int population;

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

    public boolean hasLocalAsylum(String streetName) {

        for (AsylumCentre a : localAsylumCentres) {

            if (streetName.equalsIgnoreCase(a.getStreetName())) {
                System.out.println("This asylum has already been registered in this local authority.");
                return true;
            }
        }
        return false;
    }

    public void addAsylumCentre(AsylumCentre asylumCentre) {
        localAsylumCentres.add(asylumCentre);
    }
}
