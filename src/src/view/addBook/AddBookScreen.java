package view.addBook;

import model.dto.BookDTO;
import repository.BookRepository;

import static core.Utils.SCANNER;

public class AddBookScreen {
    public static void addScreen(BookRepository repository) {
        System.out.println("Qual o nome do livro que deseja adicionar?");
        String bookName = SCANNER.nextLine().toUpperCase();
        System.out.println("Qual o gênero do livro que deseja adicionar?");
        String bookGenre = SCANNER.nextLine().toUpperCase();
        System.out.println("Quem é o autor do livro que deseja adicionar?");
        String bookAuthor = SCANNER.nextLine().toUpperCase();

        BookDTO book = new BookDTO(bookName, bookGenre, bookAuthor);
        repository.addBook(bookName, bookGenre, bookAuthor);


    }
}
