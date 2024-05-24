package utils;

import userClasses.Gebruiker;

public class Security {

    private static Security instance = null;
    private Gebruiker activeGebruiker;

    private void setActieveGebruiker(Gebruiker gebruiker) {
        this.activeGebruiker = gebruiker;
    }

    private Security() {
        setActieveGebruiker(null);
    }

    public static Security getInstance() {

        if (instance == null) {
            instance = new Security();
        }
        return instance;
    }

    public Gebruiker getActiveGebruiker() {
        return activeGebruiker;
    }

    public boolean isLoggedIn() {
        return activeGebruiker != null;
    }

    public Gebruiker login() {
        Seeder seeder = Seeder.getInstance();

        boolean loggedIn = false;

        System.out.println("Gebruikersnaam: ");

        while (!loggedIn) {
            String gebruikersnaam = MyScanner.nextLine();
            Gebruiker gebruiker = seeder.getGebruiker(gebruikersnaam);

            if (gebruiker != null) {
                setActieveGebruiker(gebruiker);
                return gebruiker;
            }
            System.out.println("Onbekend account. Probeer opnieuw.");
        }
        return null;
    }

    public void logout() {
        setActieveGebruiker(null);
    }
}
