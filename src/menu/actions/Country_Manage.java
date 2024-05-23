package menu.actions;

import menu.Menu;
import utils.CountryManager;
import utils.MenuType;
import utils.MyScanner;
import utils.Seeder;

public class Country_Manage implements IAction {

    @Override
    public void execute() {
        Seeder.getInstance().getMenu(MenuType.COUNTRY_MANAGE).showMenu();
    }
}
