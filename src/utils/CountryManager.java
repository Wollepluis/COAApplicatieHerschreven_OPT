package utils;

import appModels.Country;

import java.util.ArrayList;

public class CountryManager {

    private static final ArrayList<Country> allCountries = new ArrayList<>();

    public static boolean hasCountry(String name) {

        for (Country c : allCountries) {

            if (name.equalsIgnoreCase(c.getName())) {
                System.out.println("This country is already registered.");
                return true;
            }
        }
        return false;
    }

    public static void addCountry(Country country) {
        allCountries.add(country);
    }
}
