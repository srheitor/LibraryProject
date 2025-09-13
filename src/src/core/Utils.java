package core;

import java.util.Scanner;

public class Utils {
    public static Scanner SCANNER = new Scanner(System.in);
    public static int USER_TYPE_ADMIN = 1;
    public static int USER_TYPE_USER = 0;

    public static void cleanScreen(){
        for (int i = 0; i < 50; ++i) System.out.println();
    }

    public static void waitEnter() {
        System.out.println("\n");
        System.out.println("Pressione ENTER para continuar...");
        SCANNER.nextLine();
    }
}