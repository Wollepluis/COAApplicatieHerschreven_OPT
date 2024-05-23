package menu.actions;

import appModels.LocalAuthority;
import utils.LocalAuthorityManager;
import utils.MyScanner;

public class LocalAuthority_Add implements IAction {

    @Override
    public void execute() {

        String name;
        int population;

        System.out.print("Enter name of local authority: ");
        name = MyScanner.nextLine();

        if (!LocalAuthorityManager.hasLocalAuthority(name)) {

            System.out.print("Enter population: ");
            population = MyScanner.nextInt();
            System.out.println(name + "successfully added!");
            LocalAuthorityManager.addLocalAuthority(new LocalAuthority(name, population));
        }
        else {
            System.out.println("This country is already registered.");
        }
    }
}
