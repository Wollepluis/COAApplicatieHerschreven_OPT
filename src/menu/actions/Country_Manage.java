package menu.actions;

import utils.MenuType;
import utils.Seeder;

public class Country_Manage implements IAction {

    @Override
    public void execute() {
        Seeder.getInstance().getMenu(MenuType.COUNTRY_MANAGE).showMenu();
    }
}
