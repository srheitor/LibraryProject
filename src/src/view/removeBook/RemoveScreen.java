package view.removeBook;

import repository.BookRepository;
import view.showBooks.ShowBookScreen;

import static core.Utils.SCANNER;

public class RemoveScreen {
    public static void removeScreen(BookRepository repository) {
        ShowBookScreen.showScreen(repository);

        System.out.println("Digite o ID do livro que deseja remover: ");
        int bookID = SCANNER.nextInt();

        repository.deleteBook(bookID);
    }

    public static void printRemoveBookInfo(String bookName, String bookGenre, String bookAuthor, String bookPublisher, String bookCondition, String bookISBN){
        System.out.println("Nome do livro: " + bookName);
        System.out.println("Gênero do livro: " + bookGenre);
        System.out.println("Autor do livro: " + bookAuthor);
        System.out.println("Nome do livro: " + bookPublisher);
        System.out.println("Gênero do livro: " + bookCondition);
        System.out.println("Autor do livro: " + bookISBN);
    }

    public static void removeBookSuccessful(){
        System.out.println("Livro removido com sucesso!");
    }

    public static void removeBookError(){
        System.out.println("Livro removido com sucesso!");
    }

}
