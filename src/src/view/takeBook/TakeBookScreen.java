package view.takeBook;

import repository.BookRepository;
import view.showBooks.ShowBookScreen;

import static core.Utils.SCANNER;

public class TakeBookScreen {
    public static void takeScreen(BookRepository repository) {

        System.out.println("Digite o nome do livro que gostaria de pegar emprestado: ");
        ShowBookScreen.showScreen(repository);
        String bookName = SCANNER.nextLine().toUpperCase();

        repository.takeBook(bookName);

    }

    public static void takeBookSuccessful(){
        System.out.println("Livro emprestado com sucesso!");
    }

    public static void takeBookError(){
        System.out.println("Não foi possível pegar o livro");
    }
}
