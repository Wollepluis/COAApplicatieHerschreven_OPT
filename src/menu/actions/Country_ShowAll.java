package menu.actions;

import appModels.Country;
import utils.CountryController;

import java.util.ArrayList;

public class Country_ShowAll implements IAction {

    public String print(boolean isSafe) {
        if (isSafe) {
            return " ";
        }
        else {
            return " not ";
        }
    }

    @Override
    public void execute() {

        CountryController countryController = CountryController.getInstance();

        ArrayList<Country> allCountries = countryController.getAllCountries();

        if (!allCountries.isEmpty()) {

            System.out.println();
            System.out.println("=== All Countries ===");

            for (Country c : allCountries) {

                System.out.printf("%s, is%sconsidered safe.\n", c.getName(), print(c.getSafe()));
            }
            System.out.println("=====================");
        }
    }
}
