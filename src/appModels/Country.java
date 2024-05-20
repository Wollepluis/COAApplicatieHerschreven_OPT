package appModels;

import utils.Seeder;

import java.util.ArrayList;

public class Country {

    private String name;
    private boolean isSafe;

    private static final ArrayList<Country> countries = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public void setSafe(boolean isSafe) {
        this.isSafe = isSafe;
    }

    public String getName() {
        return this.name;
    }

    public boolean getSafe() {
        return this.isSafe;
    }

    public Country(String name, boolean isSafe) {
        this.setName(name);
        this.setSafe(isSafe);
    }

    public static boolean checkCountry(String name) {

        for (Country c : countries) {

            if (name.equalsIgnoreCase(c.getName())) {
                System.out.println("This country is already registered.");
                return true;
            }
        }
        return false;
    }

    public static void addCountry(String name, boolean isSafe) {

        if (!checkCountry(name)) {
            Country newCountry = new Country(name, isSafe);
            countries.add(newCountry);
        }
    }
}
