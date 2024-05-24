package utils;

import appModels.AZC;

import java.util.ArrayList;

public class AZC_Controller {

    private static AZC_Controller instance = null;

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

    public boolean AZCBestaat(String straatnaam) {

        for (AZC a : alleAZCs) {

            if (straatnaam.equalsIgnoreCase(a.getStraatnaam())) {
                System.out.println("Dit AZC is al geregistreerd.");
                return true;
            }
        }
        return false;
    }

    public void voegAZCToe(AZC azc) {
        alleAZCs.add(azc);
    }
}
