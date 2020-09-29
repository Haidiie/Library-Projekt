package controller;

import entity.Book;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import dao.BookManagmentInterface;

/**
 *
 * @author Heidar
 */
@Named(value = "bookController")
@RequestScoped
public class BookController {

    @Inject
    BookManagmentInterface lm;
    
    private Integer src,books;
    private String srcname,srcpublished,srcauthor,srcgenre,name,author,published,genre,text;
    private List<Book> allBooks;
   
    public void countBooks(){
        books = allBooks.size();
        text = " Books";
    }
    
    public void searchBook(){
        Book book = lm.findById(src);
        allBooks.clear();
        allBooks.add(book);
    }
    
    public void searchBookName(){
        List<Book> book = lm.findByName(srcname);
        allBooks.clear();
        allBooks = book;
    }
    
    public void searchBookPublished(){
        List<Book> book = lm.findByPublished(srcpublished);
        allBooks.clear();
        allBooks = book;
    }
    
    public void searchBookAuthor(){
        List<Book> book = lm.findByAuthor(srcauthor);
        allBooks.clear();
        allBooks = book;
    }
    
    public void searchBookGenre(){
        List<Book> book = lm.findByGenre(srcgenre);
        allBooks.clear();
        allBooks = book;
    }
    
    public void submit() {
        Book book = new Book (name, author, published, genre);
        lm.addBook(book);
        setAllBooks(lm.getAllBooks());
        fillBooks();
    }
    
    @PostConstruct
    public void fillBooks() {
        this.allBooks = lm.getAllBooks();
    }

    public void removeBook(Book b){
        lm.removeBook(b);
        fillBooks();
    }
    
    public void editBook(Book b){
        lm.updateBook(b);
        fillBooks();
    }
    
    public BookController() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Book> getAllBooks() {
        return allBooks;
    }

    public void setAllBooks(List<Book> allBooks) {
        this.allBooks = allBooks;
    }

    public Integer getSrc() {
        return src;
    }

    public void setSrc(Integer src) {
        this.src = src;
    }

    public String getSrcname() {
        return srcname;
    }

    public void setSrcname(String srcname) {
        this.srcname = srcname;
    }

    public String getSrcauthor() {
        return srcauthor;
    }

    public void setSrcauthor(String srcauthor) {
        this.srcauthor = srcauthor;
    }

    public String getSrcgenre() {
        return srcgenre;
    }

    public void setSrcgenre(String srcgenre) {
        this.srcgenre = srcgenre;
    }

    public String getSrcpublished() {
        return srcpublished;
    }

    public void setSrcpublished(String srcpublished) {
        this.srcpublished = srcpublished;
    }

    public Integer getBooks() {
        return books;
    }

    public void setBooks(Integer books) {
        this.books = books;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
