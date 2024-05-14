package appModels;

import java.util.ArrayList;

public class LocalAuthority {

    private String name;
    private int population;

    private final ArrayList<AsylumCentre> asylumCentres;

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
        asylumCentres = new ArrayList<>();
    }
}
