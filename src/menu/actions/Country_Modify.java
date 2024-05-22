package menu.actions;

import utils.CountryManager;
import utils.MyScanner;

public class Country_Modify implements IAction {

    @Override
    public void execute() {

        System.out.println("Which country would you like to modify?");

        String name = MyScanner.nextLine();

        if (!CountryManager.hasCountry(name)) {

            System.out.println("There are no countries registered called: " + name + ".");
        }
        else {

        }
    }
}
