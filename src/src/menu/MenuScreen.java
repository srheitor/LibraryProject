package menu;

import static core.Utils.SCANNER;

public class MenuScreen {
    public static int adminMenu() {
        System.out.println("01. Mostrar lista de livros");
        System.out.println("02. Adicionar um novo livro");
        System.out.println("03. Mostrar histórico de retirada de livros");
        System.out.println("04. Mostrar histórico de livros adicionados");
        System.out.println("05. Sair");
        int choice = SCANNER.nextInt();
        SCANNER.nextLine();
        return choice;
    }

    public static int userMenu() {
        System.out.println("01. Mostrar lista de livros");
        System.out.println("02. Pegar um livro");
        System.out.println("03. Devolver um livro");
        System.out.println("04. Mostrar seu histórico de retirada de livros");
        System.out.println("05. Sair");
        int choice = SCANNER.nextInt();
        SCANNER.nextLine();
        return choice;
    }
}
