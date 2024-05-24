package utils;

import appModels.LocalAuthority;

import java.util.ArrayList;

public class LocalAuthorityController {

    private static LocalAuthorityController instance = null;
    private final ArrayList<LocalAuthority> allLocalAuthorities;

    public static LocalAuthorityController getInstance() {

        if (instance == null) {
            instance = new LocalAuthorityController();
        }
        return instance;
    }

    public ArrayList<LocalAuthority> getAllLocalAuthorities() {
        return this.allLocalAuthorities;
    }

    public LocalAuthorityController() {
        this.allLocalAuthorities = new ArrayList<>();
    }

    public boolean hasLocalAuthority(String name) {

        for (LocalAuthority l : allLocalAuthorities) {

            if (name.equalsIgnoreCase(l.getName())) {
                System.out.println("This local authority has already been registered.");
                return true;
            }
        }
        return false;
    }

    public void addLocalAuthority(LocalAuthority localAuthority) {
        allLocalAuthorities.add(localAuthority);
    }
}
