package view.returnBook;

import repository.BookRepository;

import static core.Utils.SCANNER;

public class ReturnBookScreen {
    public static void returnScreen(BookRepository repository){
        System.out.println("Digite o nome do livro que gostaria de devolver: ");
        String bookName = SCANNER.nextLine().toUpperCase();

        repository.returnBook(bookName);
    }

    public static void returnBookSuccessful(){
        System.out.println("Livro devolvido com sucesso!");
    };

    public static void returnBookError(){
        System.out.println("Não foi possível pegar o livro");
    };
}
