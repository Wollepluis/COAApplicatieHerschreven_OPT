package menu.actions;

import utils.MenuType;
import utils.Seeder;

public class Gemeente_Beheer implements IAction {

    @Override
    public void execute() {
        Seeder.getInstance().getMenu(MenuType.GEMEENTE_BEHEER).toonMenu();
    }
}
