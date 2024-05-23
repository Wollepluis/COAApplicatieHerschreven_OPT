package menu.actions;

import utils.CountryManager;
import utils.MenuType;
import utils.MyScanner;
import utils.Seeder;

public class Country_Modify implements IAction {

    public String capitalize(String name) {
        return name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
    }

    @Override
    public void execute() {

        System.out.println("What country would you like to modify?");
        String name = MyScanner.nextLine();

        if (!CountryManager.hasCountry(name)) {
            System.out.println("This country is not registered in the system.");
            return;
        }
        CountryManager.setActiveCountry_Menu(name);
        Seeder.getInstance().getMenu(MenuType.COUNTRY_MODIFY).setTitle("Modifying: " + capitalize(name));
        Seeder.getInstance().getMenu(MenuType.COUNTRY_MODIFY).showMenu();
    }
}
