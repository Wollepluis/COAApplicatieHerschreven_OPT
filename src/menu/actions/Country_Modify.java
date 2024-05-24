package menu.actions;

import utils.CountryController;
import utils.MenuType;
import utils.MyScanner;
import utils.Seeder;

public class Country_Modify implements IAction {

    public String capitalize(String name) {
        return name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
    }

    @Override
    public void execute() {

        CountryController countryController = CountryController.getInstance();

        System.out.println("What country would you like to modify?");
        String name = MyScanner.nextLine();

        if (!countryController.countryExists(name)) {
            System.out.println("This country is not registered in the system.");
            return;
        }
        countryController.setActiveCountry(name);
        Seeder.getInstance().getMenu(MenuType.COUNTRY_MODIFY).setTitle("Modifying: " + capitalize(name));
        Seeder.getInstance().getMenu(MenuType.COUNTRY_MODIFY).showMenu();
    }
}
