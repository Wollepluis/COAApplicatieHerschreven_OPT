package menu.actions;

import appModels.AZC;
import appModels.Gemeente;
import utils.Gemeente_Controller;

import java.util.ArrayList;

public class B_Gemeente_showAll implements IAction {

    @Override
    public void execute(){
        System.out.println("\n==== Gemeente Rapportage ====\n");

        Gemeente_Controller gemeenteController = Gemeente_Controller.getInstance();
        ArrayList<Gemeente> alleGemeentes = gemeenteController.getAlleGemeentes();

        for (Gemeente g : alleGemeentes) {
            System.out.printf("%s, %d inwoners%n", g.getNaam(), g.getAantalInwoners());

            int totaalcapaciteit = 0;
            int teller = 0;
            int aantalVluchtelingen = 0;

            for (AZC a : g.getLocaleAZCS()) {
                totaalcapaciteit += a.getAantalPlaatsen();
                aantalVluchtelingen += a.gevestigdeVluchtelingen.size();
                teller++;
            }
            System.out.printf("aantal AZC's: %d%n", teller);
            System.out.printf("Totale capaciteit: %d%n", totaalcapaciteit);
            System.out.printf("Aantal gevestigde vluchtelingen: %d%n", aantalVluchtelingen);

            int uitkering;
            if (totaalcapaciteit == 0) {
                uitkering = 0;
            }
            else if (totaalcapaciteit > (g.getAantalInwoners() * 0.005) + 100){
                uitkering = 2000 * aantalVluchtelingen;
            }
            else {
                uitkering = 1000 * aantalVluchtelingen;
            }
            System.out.printf("Uitkering: €%d,-%n",uitkering);
            System.out.println();
        }
        System.out.println("==============================");
    }
}
