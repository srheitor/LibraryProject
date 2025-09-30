package view.showBooks;

import repository.BookRepository;

public class ShowBookScreen {
    public static void showScreen(BookRepository repository) {
        System.out.println("Aqui está o estoque dos livros: ");
        repository.showBooks();
    }

    public static void inShelves(){
        System.out.print(" | Em estoque");
        System.out.println();
    }

    public static void notInShelves(){
        System.out.print(" | Emprestado");
        System.out.println();
    }

    public static void libraryError(){
        System.out.println("Não foi possível carregar a livraria!");
    }

}
