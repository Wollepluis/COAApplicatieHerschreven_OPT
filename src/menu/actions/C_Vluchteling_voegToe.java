package menu.actions;

import appModels.Land;
import userClasses.Vluchteling;
import utils.Land_Controller;
import utils.MyScanner;
import utils.Vluchteling_Controller;

public class C_Vluchteling_voegToe implements IAction{

    @Override
    public void execute() {

        Vluchteling_Controller vluchtelingController = Vluchteling_Controller.getInstance();
        Land_Controller landController = Land_Controller.getInstance();

        String naam;
        String land;

        System.out.println("Vul onderstaande gegevens in.");
        System.out.print("Naam: ");
        naam = MyScanner.nextLine();
        System.out.print("Land van herkomst: ");
        land = MyScanner.nextLine();

        Land landVanHerkomst = landController.getLand(land);

        if (landVanHerkomst != null) {
            Vluchteling vluchteling = new Vluchteling(naam, landVanHerkomst);
            vluchtelingController.getAlleVluchtelingen().add(vluchteling);
            System.out.println(naam + " toegevoegd in het systeem.");
        }
        else {
            System.out.println("Dit land bestaat niet.");
        }
    }
}
