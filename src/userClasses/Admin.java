package userClasses;

import menu.Menu;
import utils.MenuType;
import utils.Seeder;

public class Admin extends User {

    public Admin(String username) {
        super(username);
    }

    @Override
    public Menu getMenu() {
        return Seeder.getInstance().getMenu(MenuType.ADMIN);
    }
}
