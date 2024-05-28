package appModels;

public class Land {

    private String naam;
    private boolean isVeilig;

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setVeilig(boolean isVeilig) {
        this.isVeilig = isVeilig;
    }

    public String getNaam() {
        return this.naam;
    }

    public boolean isVeilig() {
        return this.isVeilig;
    }

    public Land(String naam, boolean isVeilig) {
        this.setNaam(naam);
        this.setVeilig(isVeilig);
    }
}
