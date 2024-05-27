package menu.actions;

import appModels.Land;
import utils.Land_Controller;
import utils.MenuType;
import utils.MyScanner;
import utils.Seeder;

public class B_Land_Wijzig implements IAction {

    public String capitalize(String naam) {
        return naam.substring(0,1).toUpperCase() + naam.substring(1).toLowerCase();
    }

    @Override
    public void execute() {

        Land_Controller landController = Land_Controller.getInstance();

        System.out.println("Welk land wil je wijzigen?");
        String naam = MyScanner.nextLine();

        Land land = landController.bestaatLand(naam);

        if (land == null) {
            System.out.println("Dit land is niet geregistreerd in dit systeem.");
            return;
        }
        landController.setActiefLand(naam);
        Seeder.getInstance().getMenu(MenuType.LAND_WIJZIG).setTitel("Nu aan het wijzigen: " + capitalize(naam));
        Seeder.getInstance().getMenu(MenuType.LAND_WIJZIG).toonMenu();
    }
}
