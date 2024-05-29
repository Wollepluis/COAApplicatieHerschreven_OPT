package userClasses;

import menu.Menu;
import utils.MenuType;
import utils.Security;
import utils.Seeder;

public class COAMedewerker extends Gebruiker {

    public COAMedewerker(String gebruikersnaam) {
        super(gebruikersnaam);
    }

    @Override
    public Menu getMenu() {
        Security security = Security.getInstance();
        Seeder.getInstance().getMenu(MenuType.COA_MEDEWERKER).setTitel("Ingelogd als: " + security.getActiveGebruiker().getGebruikersnaam().toUpperCase() + " Medewerker");
        return Seeder.getInstance().getMenu(MenuType.COA_MEDEWERKER);
    }
}
