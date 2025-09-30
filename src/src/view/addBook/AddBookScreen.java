package view.addBook;

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

        repository.addBook(bookName, bookGenre, bookAuthor, bookPublisher, bookCondition, bookISBN);
    }

    public static void printAddBookInfo(String bookName, String bookGenre, String bookAuthor, String bookPublisher, String bookCondition, String bookISBN){
        System.out.println("Nome do livro: " + bookName);
        System.out.println("Gênero do livro: " + bookGenre);
        System.out.println("Autor do livro: " + bookAuthor);
        System.out.println("Nome do livro: " + bookPublisher);
        System.out.println("Gênero do livro: " + bookCondition);
        System.out.println("Autor do livro: " + bookISBN);
    }

    public static void addBookSuccessful(){
        System.out.println("Livro adicionado com sucesso!");
    }

    public static void addBookError(){
        System.out.println("Livro adicionado com sucesso!");
    }
}
