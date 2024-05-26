package utils;

import appModels.AZC;
import appModels.Gemeente;

import java.util.ArrayList;

public class AZC_Controller {

    private static AZC_Controller instance = null;
    Gemeente_Controller gemeenteController = Gemeente_Controller.getInstance();

    private final ArrayList<AZC> alleAZCs;

    public static AZC_Controller getInstance() {

        if (instance == null) {
            instance = new AZC_Controller();
        }
        return instance;
    }

    public ArrayList<AZC> getAlleAZCs() {
        return alleAZCs;
    }

    private AZC_Controller() {
        this.alleAZCs = new ArrayList<>();
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

    public void voegAZCToe(Gemeente gemeente, AZC azc) {
        this.alleAZCs.add(azc);
        gemeenteController.voegLokaalAZCToe(gemeente, azc);
    }

    public void verwijderAZC(Gemeente gemeente, AZC azc) {
        this.alleAZCs.remove(azc);
        gemeenteController.verwijderLokaalAZC(gemeente, azc);
    }
}
