package menu.actions;

import appModels.Gemeente;
import utils.Gemeente_Controller;
import utils.MyScanner;

public class Gemeente_VoegToe implements IAction {

    @Override
    public void execute() {

        Gemeente_Controller gemeenteController = Gemeente_Controller.getInstance();

        String naam;
        int aantalInwoners;

        System.out.print("Voer naam van gemeente in: ");
        naam = MyScanner.nextLine();

        Gemeente gemeente = gemeenteController.getGemeente(naam);

        if (gemeente == null) {

            System.out.print("Geef het aantal inwoners op: ");
            aantalInwoners = MyScanner.nextInt();
            System.out.println(naam + " toegevoegd!");
            gemeenteController.voegGemeenteToe(new Gemeente(naam, aantalInwoners));
        }
        else {
            System.out.println("Deze gemeente is al geregistreerd.");
        }
    }
}
