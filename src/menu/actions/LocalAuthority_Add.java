package menu.actions;

import appModels.LocalAuthority;
import utils.LocalAuthorityController;
import utils.MyScanner;

public class LocalAuthority_Add implements IAction {

    @Override
    public void execute() {

        LocalAuthorityController localAuthorityController = LocalAuthorityController.getInstance();

        String name;
        int population;

        System.out.print("Enter name of local authority: ");
        name = MyScanner.nextLine();

        if (!localAuthorityController.hasLocalAuthority(name)) {

            System.out.print("Enter population: ");
            population = MyScanner.nextInt();
            System.out.println(name + "successfully added!");
            localAuthorityController.addLocalAuthority(new LocalAuthority(name, population));
        }
        else {
            System.out.println("This country is already registered.");
        }
    }
}
