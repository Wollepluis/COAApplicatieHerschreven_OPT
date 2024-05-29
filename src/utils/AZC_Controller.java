package utils;

import appModels.AZC;
import appModels.Adres;
import appModels.Gemeente;

public class AZC_Controller {

    private static AZC_Controller instance = null;
    Gemeente_Controller gemeenteController = Gemeente_Controller.getInstance();

    public static AZC_Controller getInstance() {

        if (instance == null) {
            instance = new AZC_Controller();
        }
        return instance;
    }

    public AZC getAZC(Gemeente gemeente, Adres adres) {

        for (AZC a : gemeente.getLocaleAZCS()) {

            if (adres.equals(a.getAdres())) {
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
