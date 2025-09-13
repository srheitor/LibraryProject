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
        System.out.println("Qual a editora do livro que deseja adicionar?");
        String bookPublisher = SCANNER.nextLine().toUpperCase();
        System.out.println("Qual a condição que se encontra o livro que deseja adicionar?");
        String bookCondition = SCANNER.nextLine().toUpperCase();
        System.out.println("Digite o ISBN (International Standard Book Number) do livro: ?");
        String bookISBN = SCANNER.nextLine().toUpperCase();

        BookDTO book = new BookDTO(bookName, bookGenre, bookAuthor, bookPublisher, bookCondition, bookISBN);
        repository.addBook(bookName, bookGenre, bookAuthor, bookPublisher, bookCondition, bookISBN);


    }
}
