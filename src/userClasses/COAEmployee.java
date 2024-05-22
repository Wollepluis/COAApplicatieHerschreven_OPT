package userClasses;

import menu.Menu;
import utils.MenuType;
import utils.Seeder;

public class COAEmployee extends User{

    public COAEmployee(String username) {
        super(username);
    }

    @Override
    public Menu getMenu() {
        return Seeder.getInstance().getMenu(MenuType.COA_EMPLOYEE);
    }
}
