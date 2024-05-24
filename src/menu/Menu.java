package menu;

import utils.MyScanner;

import java.util.ArrayList;

public class Menu {

    private String titel;
    private int laatsteKeuze;
    private ArrayList<Menukeuze> menukeuzes;

    public void setTitel(String titel) {
        this.titel = titel;
    }

    private void setLaatsteKeuze(int laatsteKeuze) {
        this.laatsteKeuze = laatsteKeuze;
    }

    private void resetLaatsteKeuze() {
        setLaatsteKeuze(-1);
    }

    public void resetMenukeuze() {
        menukeuzes = new ArrayList<>();
        resetLaatsteKeuze();
    }

    public int getLaatsteKeuze() {
        return this.laatsteKeuze;
    }

    public Menu(String titel) {
        this.setTitel(titel);
        this.resetMenukeuze();
        this.resetLaatsteKeuze();
    }

    public void voegMenukeuzeToe(Menukeuze menukeuze) {
        menukeuzes.add(menukeuze);
        menukeuze.setKeuze(menukeuzes.size());
    }

    public Menukeuze getJuisteMenukeuze(int keuze) {

        for (Menukeuze menukeuze : menukeuzes) {

            if (menukeuze.getKeuze() == keuze) {
                return menukeuze;
            }
        }
        return null;
    }

    public void toonMenu() {
        System.out.println();
        System.out.printf("=== %s%n", this.titel);

        for (Menukeuze menukeuze : menukeuzes) {
            menukeuze.toonMenukeuze();
        }

        System.out.println();
        System.out.print("Keuze: ");
        setLaatsteKeuze(MyScanner.nextInt());
        Menukeuze menukeuze = getJuisteMenukeuze(getLaatsteKeuze());

        if (menukeuze != null) {
            menukeuze.execute();
        }
        else {
            System.out.println("ERROR: Ongeldige keuze.");
        }
    }
}
