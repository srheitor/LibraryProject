package model.dto;

public class BookDTO {
    private int idBook;
    private String bookName;
    private int bookStatus;
    private String bookGenre;
    private String bookAuthor;
    private String bookPublisher;
    private String bookCondition;
    private String bookISBN;

    public BookDTO(String bookName, String bookGenre, String bookAuthor, String bookPublisher, String bookCondition, String bookISBN) {
        this.bookName = bookName;
        this.bookGenre = bookGenre;
        this.bookAuthor = bookAuthor;
        this.bookPublisher = bookPublisher;
        this.bookCondition = bookCondition;
        this.bookISBN = bookISBN;
    }
}
