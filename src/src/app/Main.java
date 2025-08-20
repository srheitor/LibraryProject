package app;

import static core.Utils.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Olá, seja bem vindo a livraria de teste do Heitor! \n" +
                           "O que você deseja fazer?");

        int choice = Menu();
        switch (choice){
            case 1 -> System.out.println("Você pegou um livro");
            case 2 -> System.out.println("Você devolveu um livro");
            case 3 -> System.out.println("Você adicionou um livro");
            case 4 -> System.out.println("Você saiu");

        }

        //MyJDBC.conect();

    }
    public static int Menu(){
        System.out.println("01. Pegar um livro");
        System.out.println("02. Devolver um livro");
        System.out.println("03. Adicionar um novo livro");
        System.out.println("04. Sair");
        int choice = SCANNER.nextInt();
        SCANNER.nextLine();
        return choice;
    }
}