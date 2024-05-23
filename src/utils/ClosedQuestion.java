package utils;

public class ClosedQuestion {
    public static boolean question(String question) {
        String answer = "YN";
        String choice;

        choice = "<><><><><><><><><>";
        while (!answer.contains(choice.toUpperCase())) {
            if (!choice.equals("<><><><><><><><><>")) {
                System.out.println("Input a answer shown on screen.");
            }
            System.out.println(question +  " [Y]es/[N]o");
            choice = MyScanner.nextLine();
            System.out.println();
        }
        return choice.equalsIgnoreCase("Y");
    }
}