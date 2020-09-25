package controller;

import dao.LibraryManagmentInterface;
import entity.Library;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Heidar
 */
@Named(value = "libraryController")
@RequestScoped
public class LibraryController {

    @Inject
    LibraryManagmentInterface lm;
    
    
    private int src;
    private String srcname;
    private String srcauthor;
    private String srcgenre;
    private String name;
    private String author;
    private int published;
    private String genre;
    private List<Library> allBooks;
    
    public void searchBook(){
        Library library = lm.findById(src);
        allBooks.clear();
        allBooks.add(library);
    }
    
   
    public void searchBookName(){
        List<Library> library = lm.findByName(srcname);
        allBooks.clear();
        allBooks = library;
    }
    
    public void searchBookAuthor(){
        List<Library> library = lm.findByAuthor(srcauthor);
        allBooks.clear();
        allBooks = library;
    }
    
    public void searchBookGenre(){
        List<Library> library = lm.findByGenre(srcgenre);
        allBooks.clear();
        allBooks = library;
    }
    
    
    
    
    public void submit() {
        Library library = new Library (name, author, published, genre);
        lm.addBook(library);
        setAllBooks(lm.getAllBooks());
        fillBooks();
    }
    
    @PostConstruct
    public void fillBooks() {
        this.allBooks = lm.getAllBooks();
    }
    
    public void removeBook(Library l){
        lm.removeBook(l);
        fillBooks();
    }
    
    public void editBook(Library l){
        lm.updateBook(l);
        fillBooks();
    }
    
    
    
    
    public LibraryController() {
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

    public int getPublished() {
        return published;
    }

    public void setPublished(int published) {
        this.published = published;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Library> getAllBooks() {
        return allBooks;
    }

    public void setAllBooks(List<Library> allBooks) {
        this.allBooks = allBooks;
    }

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
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

    

    
}
