package utils;

import java.util.Scanner;

public class MyScanner {
    public static String nextLine() {
        Scanner s = new Scanner(System.in);
        while (true) {
            if (s.hasNextLine()) {
                return s.nextLine();
            } else {
                System.out.print("Voer een geldige tekst in: ");
                s.next();
            }
        }

    }

    public static int nextInt(){
        Scanner s = new Scanner(System.in);
        while (true) {
            if (s.hasNextInt()) {
                return s.nextInt();
            } else {
                System.out.print("Voer een getal: ");
                s.next();
            }
        }
    }
}
