package view.returnBook;

import model.dto.BookDTO;
import repository.BookRepository;

import static core.Utils.SCANNER;

public class returnBookScreen {
    public static void returnScreen(BookRepository repository){
        System.out.println("Digite o nome do livro que gostaria de devolver: ");
        String bookName = SCANNER.nextLine().toUpperCase();
    }
}
