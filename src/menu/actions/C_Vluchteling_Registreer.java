package menu.actions;

import appModels.AZC;
import appModels.Adres;
import appModels.Gemeente;
import userClasses.Vluchteling;
import utils.*;

public class C_Vluchteling_Registreer implements IAction {

    @Override
    public void execute() {

        Gemeente_Controller gemeenteController = Gemeente_Controller.getInstance();
        AZC_Controller azcController = AZC_Controller.getInstance();
        Adres_Controller adresController = Adres_Controller.getInstance();
        Vluchteling_Controller vluchtelingController = Vluchteling_Controller.getInstance();

        System.out.println("Voerde naam in van de vluchteling die u wilt registreren.");
        String naam = MyScanner.nextLine();

        Vluchteling vluchteling = vluchtelingController.getVluchteling(naam);

        if (vluchteling != null) {

            String gemeenteNaam;
            System.out.println("In welk AZC wilt u deze vluchteling registreren?");
            System.out.print("Gemeente: ");

            gemeenteNaam = MyScanner.nextLine();
            Gemeente gemeente = gemeenteController.getGemeente(gemeenteNaam);

            if (gemeente != null) {
                Adres adres = adresController.vulAdresIn();
                AZC azc = azcController.getAZC(gemeente, adres);

                if (azc != null) {
                    vluchteling.setGeregistreerd(true);
                    azc.gevestigdeVluchtelingen.add(vluchteling);
                    System.out.println(naam + "geregistreerd in" + gemeente.getNaam());
                }
                else {
                    System.out.println("Dit AZC bestaat niet.");
                }
            }
            else {
                System.out.println("Deze gemeente bestaat niet.");
            }
        }
        else {
            System.out.println("Deze vluchteling staat niet in het systeem.");
        }
    }
}
