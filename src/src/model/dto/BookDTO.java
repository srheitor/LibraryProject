package model.dto;

public class BookDTO {
    private int idbook;
    private String bookname;
    private int bookstate;
    private String bookgenre;
    private String bookAuthor;

    public BookDTO(String bookname, String bookgenre, String bookAuthor) {
        this.bookname = bookname;
        this.bookgenre = bookgenre;
        this.bookAuthor = bookAuthor;
    }

    public int getIdbook() {
        return idbook;
    }

    public void setIdbook(int idbook) {
        this.idbook = idbook;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public int getBookstate() {
        return bookstate;
    }

    public void setBookstate(int bookstate) {
        this.bookstate = bookstate;
    }

    public String getBookgenre() {
        return bookgenre;
    }

    public void setBookgenre(String bookgenre) {
        this.bookgenre = bookgenre;
    }

}
