package utils;

import appModels.Country;

import java.util.ArrayList;

public class CountryController {

    private static CountryController instance = null;

    private Country activeCountry;
    private final ArrayList<Country> allCountries;

    public static CountryController getInstance() {

        if (instance == null) {
            instance = new CountryController();
        }
        return instance;
    }

    public Country getActiveCountry() {
        return activeCountry;
    }

    public void resetActiveCountry() {
        activeCountry = null;
    }

    public ArrayList<Country> getAllCountries() {
        return allCountries;
    }

    public void setActiveCountry(String activeCountry) {

        for (Country c : allCountries) {

            if (activeCountry.equalsIgnoreCase(c.getName())) {
                this.activeCountry = c;
            }
        }
    }

    private CountryController() {
        this.allCountries  = new ArrayList<>();
    }

    public boolean countryExists(String name) {

        for (Country c : allCountries) {

            if (name.equalsIgnoreCase(c.getName())) {
                return true;
            }
        }
        return false;
    }

    public void addCountry(Country country) {
        allCountries.add(country);
    }
}
