package utils;

import appModels.Country;

import java.util.ArrayList;

public class CountryManager {

    private static String activeCountry_Menu;

    private static final ArrayList<Country> allCountries = new ArrayList<>();

    public static void setActiveCountry_Menu(String activeCountry_Menu) {
        CountryManager.activeCountry_Menu = activeCountry_Menu;
    }

    public static String getActiveCountry_Menu() {
        return activeCountry_Menu;
    }

    public static void resetActiveCountry_Menu() {
        activeCountry_Menu = null;
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
