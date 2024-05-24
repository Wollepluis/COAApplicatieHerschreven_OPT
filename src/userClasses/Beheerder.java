package userClasses;

import menu.Menu;
import utils.MenuType;
import utils.Security;
import utils.Seeder;

public class Beheerder extends Gebruiker {

    public Beheerder(String gebruikersnaam) {
        super(gebruikersnaam);
    }

    @Override
    public Menu getMenu() {
        Security security = Security.getInstance();
        Seeder.getInstance().getMenu(MenuType.BEHEERDER).setTitel("Ingelogd als: " + security.getActiveGebruiker().getGebruikersnaam());
        return Seeder.getInstance().getMenu(MenuType.BEHEERDER);
    }
}
