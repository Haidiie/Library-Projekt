package dao;

import entity.Library;
import java.util.List;

/**
 *
 * @author Heidar
 */
public interface LibraryManagmentInterface {
    
    public void addBook(Library l);
    public Library findById(int id);
    public List<Library> getAllBooks();
    public void updateBook(Library l);
    public void removeBook(Library l);
    
}
