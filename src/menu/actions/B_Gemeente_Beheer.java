package menu.actions;

import utils.MenuType;
import utils.Seeder;

public class B_Gemeente_Beheer implements IAction {

    @Override
    public void execute() {
        Seeder.getInstance().getMenu(MenuType.GEMEENTE_BEHEER).toonMenu();
    }
}
