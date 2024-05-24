package utils;

import userClasses.Gebruiker;

public class Security {

    private static Security instance = null;
    private Gebruiker activeGebruiker;

    private void setActiveUser(Gebruiker gebruiker) {
        this.activeGebruiker = gebruiker;
    }

    private Security() {
        setActiveUser(null);
    }

    public static Security getInstance() {

        if (instance == null) {
            instance = new Security();
        }
        return instance;
    }

    public Gebruiker getActiveUser() {
        return activeGebruiker;
    }

    public boolean isLoggedIn() {
        return activeGebruiker != null;
    }

    public Gebruiker login() {
        Seeder seeder = Seeder.getInstance();

        boolean loggedIn = false;

        System.out.println("Enter username: ");

        while (!loggedIn) {
            String username = MyScanner.nextLine();
            Gebruiker gebruiker = seeder.getGebruiker(username);

            if (gebruiker != null) {
                setActiveUser(gebruiker);
                return gebruiker;
            }
            System.out.println("Unknown user. Try again.");
        }
        return null;
    }

    public void logout() {
        setActiveUser(null);
    }
}
