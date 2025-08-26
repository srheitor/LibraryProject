package app;

import core.Utils;

import java.sql.SQLException;

import static core.Utils.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("Olá, seja bem vindo a livraria de teste do Heitor! \n" +
                "Por favor digite seu usuário e senha: ");

        String user = SCANNER.nextLine();
        int psw = SCANNER.nextInt();

        if () {
            System.out.println("Olá admin!, o que gostaria de fazer?");
            int choice = AdminMenu();
            switch (choice) {
                case 1 -> {
                    System.out.println("Selecione qual livro você deseja pegar (Digite o ID do livro): ");
                    Utils.showBooks();
                    int bookId = SCANNER.nextInt();
                    takeBook(bookId);

                }

                case 2 -> System.out.println("Você devolveu um livro");
                case 3 -> System.out.println("Você adicionou um livro");
                case 4 -> System.out.println("Você saiu");

            }
        } else if () {
            System.out.println("Olá usuario!, o que gostaria de fazer?");
        }


    }

    public static int AdminMenu() {
        System.out.println("01. Pegar um livro");
        System.out.println("02. Devolver um livro");
        System.out.println("03. Adicionar um novo livro");
        System.out.println("04. Sair");
        int choice = SCANNER.nextInt();
        SCANNER.nextLine();
        return choice;
    }
}
