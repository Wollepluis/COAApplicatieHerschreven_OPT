public class Seeder {

    private static Seeder instance = null;

    private void initialize() {

    }

    private Seeder() {
        initialize();
    }

    public static Seeder getInstance() {

        if (instance == null) {
            instance = new Seeder();
        }
        return instance;
    }
}
