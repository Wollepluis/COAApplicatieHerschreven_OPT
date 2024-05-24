package menu.actions;

import appModels.Land;
import utils.Land_Controller;

import java.util.ArrayList;

public class Land_ShowAll implements IAction {

    public String print(boolean isVeilig) {
        if (isVeilig) {
            return "veilig";
        }
        else {
            return "onveilig";
        }
    }

    @Override
    public void execute() {

        Land_Controller landController = Land_Controller.getInstance();

        ArrayList<Land> alleLanden = landController.getAlleLanden();

        if (!alleLanden.isEmpty()) {

            System.out.println();
            System.out.println("=== Alle landen ===");

            for (Land l : alleLanden) {

                System.out.printf("%-15s [%s]\n", l.getNaam(), print(l.getVeilig()));
            }
            System.out.println("===================");
        }
    }
}
