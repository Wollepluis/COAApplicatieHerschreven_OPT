package userClasses;

import menu.Menu;
import utils.MenuType;
import utils.Seeder;

public class COAMedewerker extends Gebruiker {

    public COAMedewerker(String gebruikersnaam) {
        super(gebruikersnaam);
    }

    @Override
    public Menu getMenu() {
        return Seeder.getInstance().getMenu(MenuType.COA_MEDEWERKER);
    }
}
