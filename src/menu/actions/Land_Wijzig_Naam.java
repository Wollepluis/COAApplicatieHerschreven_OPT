package menu.actions;

import appModels.Land;
import utils.Land_Controller;
import utils.MyScanner;

import java.util.ArrayList;

public class Land_Wijzig_Naam implements IAction {

    @Override
    public void execute() {

        Land_Controller landController = Land_Controller.getInstance();

        System.out.print("Geef nieuwe naam op: ");
        String nieuweNaam = MyScanner.nextLine();

        if (nieuweNaam.isBlank()) {
            System.out.println("Wijziging geannuleerd.");
        }
        else {
            ArrayList<Land> alleLanden = landController.getAlleLanden();

            for (Land l : alleLanden) {

                if (landController.getActiefLand().equals(l.getNaam())) {
                    l.setNaam(nieuweNaam);
                }
            }
        }
    }
}
