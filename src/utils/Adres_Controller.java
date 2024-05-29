package utils;

import appModels.Adres;

public class Adres_Controller {

    private static Adres_Controller instance = null;

    public static Adres_Controller getInstance() {

        if (instance == null) {
            instance = new Adres_Controller();
        }
        return instance;
    }

    public Adres vulAdresIn() {

        System.out.print("Postcode: ");
        String postcode = MyScanner.nextLine();
        System.out.print("Straatnaam: ");
        String straatnaam = MyScanner.nextLine();
        System.out.print("huisnummer: ");
        int huisnummer = MyScanner.nextInt();

        return new Adres(postcode, straatnaam, huisnummer);
    }
}
