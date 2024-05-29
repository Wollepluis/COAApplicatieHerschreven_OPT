package menu.actions;

import appModels.AZC;
import appModels.Adres;
import appModels.Gemeente;
import utils.AZC_Controller;
import utils.Adres_Controller;
import utils.Gemeente_Controller;
import utils.MyScanner;

public class B_AZC_Verwijder implements IAction {

    @Override
    public void execute() {

        AZC_Controller azcController = AZC_Controller.getInstance();
        Adres_Controller adresController = Adres_Controller.getInstance();
        Gemeente_Controller gemeenteController = Gemeente_Controller.getInstance();

        String naamGemeente;

        System.out.println("Uit welke gemeente wilt u een AZC verwijderen?");
        naamGemeente = MyScanner.nextLine();

        Gemeente gemeente = gemeenteController.getGemeente(naamGemeente);

        if (gemeente != null) {

            if (!gemeente.getLocaleAZCS().isEmpty()) {

                System.out.println("Geef de volgende gegevens van het AZC op.");

                Adres adres = adresController.vulAdresIn();
                AZC azc = azcController.getAZC(gemeente, adres);

                if (azc != null) {

                    if (azcController.checkIfEmpty(azc)) {

                        azcController.verwijderAZC(gemeente, azc);
                        System.out.println("AZC verwijderd.");
                    } else {

                        System.out.println("In dit AZC zijn nog vluchtelingen gehuisvest.");
                        System.out.println("Plaats deze vluchtelingen eerst over naar een ander AZC om te verwijderen.");
                    }
                }
                else {
                    System.out.println("Dit AZC bestaat niet.");
                }
            }
            else {
                System.out.println("Deze gemeente heeft geen AZCs");
            }
        }
        else {
            System.out.println("Deze gemeente bestaat niet.");
        }
    }
}
