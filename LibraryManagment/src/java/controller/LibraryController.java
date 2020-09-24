package controller;

import dao.LibraryManagmentInterface;
import entity.Library;
import java.util.List;
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
    
    private String name;
    private String author;
    private int year;
    private String genre;
    private List<Library> allBooks;
    
    public void submit() {
        Library library = new Library (name, author, year, genre);
        lm.addBook(library);
        setAllBooks(lm.getAllBooks());
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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
    
    
    
}
