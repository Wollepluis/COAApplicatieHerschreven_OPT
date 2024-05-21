package appModels;

import java.util.ArrayList;

public class AsylumCentre {

    private LocalAuthority localAuthority;
    private String postalCode;
    private String streetName;
    private int houseNumber;
    private int availabilityNumber;

    public void setLocalAuthority(LocalAuthority localAuthority) {
        this.localAuthority = localAuthority;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setAvailabilityNumber(int availabilityNumber) {
        this.availabilityNumber = availabilityNumber;
    }

    public String getLocalAuthority() {
        return this.localAuthority.getName();
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public String getStreetName() {
        return this.streetName;
    }

    public int getHouseNumber() {
        return this.houseNumber;
    }

    public int getAvailabilityNumber() {
        return this.availabilityNumber;
    }

    public AsylumCentre(LocalAuthority localAuthority, String postalCode, String streetName, int houseNumber, int availabilityNumber) {
        this.setLocalAuthority(localAuthority);
        this.setPostalCode(postalCode);
        this.setStreetName(streetName);
        this.setHouseNumber(houseNumber);
        this.setAvailabilityNumber(availabilityNumber);
    }
}
