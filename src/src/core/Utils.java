package core;

import java.util.Scanner;

public class Utils {
    public static Scanner SCANNER = new Scanner(System.in);
    public static String USER_TYPE_ADMIN = "ADMIN";
    public static String USER_TYPE_USER = "USER";

    public static void cleanScreen(){
        for (int i = 0; i < 50; ++i) System.out.println();
    }

    public static void waitEnter() {
        System.out.println("\n");
        System.out.print("Pressione ENTER para continuar...");
        SCANNER.nextLine();
    }

    public static void invalidInput() {
        System.out.println("\n");
        System.out.println("POR FAVOR DIGITE APENAS UM NÚMERO REFERENTE A OPÇÃO DESEJADA!");
    }
}