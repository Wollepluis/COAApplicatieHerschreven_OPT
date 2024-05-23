package utils;

import appModels.Country;

import java.util.ArrayList;

public class CountryManager {

    private static String activeCountry;

    private static final ArrayList<Country> allCountries = new ArrayList<>();

    public static void setActiveCountry(String activeCountry) {
        CountryManager.activeCountry = activeCountry;
    }

    public static String getActiveCountry() {
        return activeCountry;
    }

    public static void resetActiveCountry() {
        activeCountry = null;
    }

    public static ArrayList<Country> getAllCountries() {
        return allCountries;
    }

    public static boolean hasCountry(String name) {

        for (Country c : allCountries) {

            if (name.equalsIgnoreCase(c.getName())) {
                return true;
            }
        }
        return false;
    }

    public static void addCountry(Country country) {
        allCountries.add(country);
    }
}
