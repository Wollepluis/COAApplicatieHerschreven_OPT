import menu.Menu;
import utils.Seeder;

public class Main {
    public static void main(String[] args) {
        Seeder seeder = Seeder.getInstance();

        while(true) {
            Menu menu = seeder.getMenu();
            menu.toonMenu();
        }
    }
}
