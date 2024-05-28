package menu.actions;

import utils.Land_Controller;
import utils.MyScanner;

public class B_Land_Wijzig_Naam implements IAction {

    @Override
    public void execute() {

        Land_Controller landController = Land_Controller.getInstance();

        System.out.print("Geef nieuwe naam op: ");
        String nieuweNaam = MyScanner.nextLine();

        if (nieuweNaam.isBlank()) {
            System.out.println("Wijziging geannuleerd.");
        }
        else {
            landController.getActiefLand().setNaam(nieuweNaam);
            System.out.println("Naam gewijzigd.");
        }
    }
}
