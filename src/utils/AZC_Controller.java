package utils;

import appModels.AZC;
import appModels.Gemeente;

import java.util.ArrayList;

public class AZC_Controller {

    private static AZC_Controller instance = null;
    Gemeente_Controller gemeenteController = Gemeente_Controller.getInstance();

    public static AZC_Controller getInstance() {

        if (instance == null) {
            instance = new AZC_Controller();
        }
        return instance;
    }

    public AZC bestaatAZC(Gemeente gemeente, String postcode, String straatnaam, int huisnummer) {

        for (AZC a : gemeente.getLocaleAZCS()) {

            if (postcode.equalsIgnoreCase(a.getPostcode()) && straatnaam.equalsIgnoreCase(a.getStraatnaam()) && huisnummer == a.getHuisnummer()) {
                return a;
            }
        }
        return null;
    }

    public boolean checkIfEmpty(AZC azc) {
        return azc.gevestigdeVluchtelingen.isEmpty();
    }

    public void verwijderAZC(Gemeente gemeente, AZC azc) {
        gemeenteController.verwijderLokaalAZC(gemeente, azc);
    }
}
