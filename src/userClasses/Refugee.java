package userClasses;

import appModels.Country;

public class Refugee extends User {

    private String name;
    private Country countryOfOrigin;

    public Refugee(String username) {
        super(username);

    }
}
