package dao;

import entity.Book;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Heidar
 */
@Stateless
public class BookManagment implements BookManagmentInterface {
    
    @PersistenceContext
    EntityManager em;

    @Override
    public void addBook(Book b) {
        em.persist(b);
    }

    @Override
    public Book findById(Integer id) {
        return em.find(Book.class, id);
    }
    
    @Override
    public List <Book> findByName(String name) {
        Query q = em.createQuery(
        "SELECT b FROM Book b WHERE b.name LIKE :bookName")
        .setParameter("bookName", name);
        return q.getResultList();
    }
    
    @Override
    public List <Book> findByPublished(String published) {
        Query q = em.createQuery(
        "SELECT b FROM Book b WHERE b.published LIKE :bookYear")
        .setParameter("bookYear", published);
        return q.getResultList();
    }
    
    @Override
    public List <Book> findByAuthor(String author) {
        Query q = em.createQuery(
        "SELECT b FROM Book b WHERE b.author LIKE :bookAuthor")
        .setParameter("bookAuthor", author);
        return q.getResultList();
    }
    
    @Override
    public List <Book> findByGenre(String genre) {
        Query q = em.createQuery(
        "SELECT b FROM Book b WHERE b.genre LIKE :bookGenre")
        .setParameter("bookGenre", genre);
        return q.getResultList();
    }
    
    
    @Override
    public List<Book> getAllBooks() {
        Query q = em.createQuery("SELECT b FROM Book b");
        return q.getResultList();
    }

    @Override
    public void updateBook(Book b) {
        em.merge(b);
    }

    @Override
    public void removeBook(Book b) {
        if (!em.contains(b)) {
            b = em.merge(b);
        }
        em.remove(b);
    }

    
}
