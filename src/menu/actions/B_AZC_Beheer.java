package menu.actions;

import utils.MenuType;
import utils.Seeder;

public class B_AZC_Beheer implements IAction {

    @Override
    public void execute() {
        Seeder.getInstance().getMenu(MenuType.AZC_BEHEER).toonMenu();
    }
}
