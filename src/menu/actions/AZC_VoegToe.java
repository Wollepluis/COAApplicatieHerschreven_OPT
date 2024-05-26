package menu.actions;

import appModels.AZC;
import appModels.Gemeente;
import utils.AZC_Controller;
import utils.Gemeente_Controller;
import utils.MyScanner;

public class AZC_VoegToe implements IAction {

    @Override
    public void execute() {

        AZC_Controller azcController = AZC_Controller.getInstance();
        Gemeente_Controller gemeenteController = Gemeente_Controller.getInstance();

        String naamGemeente;
        String postcode;
        String straatnaam;
        int huisnummer;
        int aantalPlaatsen;

        System.out.println("In welke gemeente wil je een AZC plaatsen?");
        naamGemeente = MyScanner.nextLine();

        Gemeente gemeente = gemeenteController.getGemeente(naamGemeente);

        if (gemeente != null) {
            System.out.println("Geef de volgende gegevens van het AZC op.");
            System.out.print("Postcode: ");
            postcode = MyScanner.nextLine();
            System.out.print("Straatnaam: ");
            straatnaam = MyScanner.nextLine();
            System.out.print("huisnummer: ");
            huisnummer = MyScanner.nextInt();

            AZC azc = azcController.bestaatAZC(gemeente, postcode, straatnaam, huisnummer);

            if (azc == null) {
                gemeenteController.voegLokaalAZCToe(gemeente, azc);
            }
        }
        else {
            System.out.println("Deze gemeente bestaat niet.");
        }
    }
}
