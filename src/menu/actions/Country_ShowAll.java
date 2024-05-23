package menu.actions;

import appModels.Country;
import utils.CountryManager;

import java.util.ArrayList;

public class Country_ShowAll implements IAction {

    public String print(boolean isSafe) {
        if (isSafe) {
            return "wel";
        }
        else {
            return "niet";
        }
    }

    @Override
    public void execute() {
        ArrayList<Country> allCountries = CountryManager.getAllCountries();

        if (!allCountries.isEmpty()) {

            System.out.println();
            System.out.println("=== All Countries ===");

            for (Country c : allCountries) {

                System.out.printf("%s, is %s veilig.\n", c.getName(), print(c.getSafe()));
            }
            System.out.println("=====================");
        }
    }
}
