package dao;

import entity.Book;
import java.util.List;

/**
 *
 * @author Heidar
 */
public interface BookManagmentInterface {
    
    public void addBook(Book b);
    public Book findById(Integer id);
    public List <Book> findByName(String name);
    public List <Book> findByPublished(String published);
    public List <Book> findByAuthor(String author);
    public List <Book> findByGenre(String genre);
    public List <Book> getAllBooks();
    public void updateBook(Book b);
    public void removeBook(Book b);
    
}
