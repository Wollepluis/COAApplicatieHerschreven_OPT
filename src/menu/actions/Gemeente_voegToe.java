package menu.actions;

import appModels.Gemeente;
import utils.Gemeente_Controller;
import utils.MyScanner;

public class Gemeente_voegToe implements IAction {

    @Override
    public void execute() {

        Gemeente_Controller gemeenteController = Gemeente_Controller.getInstance();

        String naam;
        int aantalInwoners;

        System.out.print("Voer naam van land in: ");
        naam = MyScanner.nextLine();

        if (!gemeenteController.GemeenteBestaat(naam)) {

            System.out.print("Geef het aantal inwoners op: ");
            aantalInwoners = MyScanner.nextInt();
            System.out.println(naam + "toegevoegd!");
            gemeenteController.voegGemeenteToe(new Gemeente(naam, aantalInwoners));
        }
        else {
            System.out.println("Deze gemeente is al geregistreerd.");
        }
    }
}
