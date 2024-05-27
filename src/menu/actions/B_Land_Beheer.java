package menu.actions;

import utils.MenuType;
import utils.Seeder;

public class B_Land_Beheer implements IAction {

    @Override
    public void execute() {
        Seeder.getInstance().getMenu(MenuType.LAND_BEHEER).toonMenu();
    }
}
