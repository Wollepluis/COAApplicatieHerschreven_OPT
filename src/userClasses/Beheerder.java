package userClasses;

import menu.Menu;
import utils.MenuType;
import utils.Seeder;

public class Beheerder extends Gebruiker {

    public Beheerder(String gebruikersnaam) {
        super(gebruikersnaam);
    }

    @Override
    public Menu getMenu() {
        return Seeder.getInstance().getMenu(MenuType.BEHEERDER);
    }
}
