package menu.actions;

import appModels.Country;
import utils.CountryManager;
import utils.MyScanner;

import java.util.ArrayList;

public class Country_NameChange implements IAction {

    @Override
    public void execute() {

        System.out.print("Enter new name of country: ");
        String newName = MyScanner.nextLine();

        if (newName.isBlank()) {
            System.out.println("Name change canceled.");
        }
        else {
            ArrayList<Country> allCountries = CountryManager.getAllCountries();

            for (Country c : allCountries) {

                if (CountryManager.getActiveCountry().equals(c.getName())) {
                    c.setName(newName);
                }
            }
        }
    }
}
