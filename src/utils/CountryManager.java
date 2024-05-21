package utils;

import appModels.Country;

import java.util.ArrayList;

public class CountryManager {

    private static final ArrayList<Country> countries = new ArrayList<>();

    public static boolean hasCountry(String name) {

        for (Country c : countries) {

            if (name.equalsIgnoreCase(c.getName())) {
                System.out.println("This country is already registered.");
                return true;
            }
        }
        return false;
    }

    public static void addCountry(Country country) {
        countries.add(country);
    }
}
