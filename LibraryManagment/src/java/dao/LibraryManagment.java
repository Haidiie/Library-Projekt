package dao;

import entity.Library;
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
public class LibraryManagment implements LibraryManagmentInterface {
    
    @PersistenceContext (name = "LibraryManagmentPU")
    EntityManager em;

    @Override
    public void addBook(Library l) {
        em.persist(l);
    }

    @Override
    public Library findById(int id) {
        return em.find(Library.class, id);
    }
    
    @Override
    public List <Library> findByName(String name) {
        Query q = em.createQuery(
        "SELECT b FROM Library b WHERE b.name LIKE :bookName")
        .setParameter("bookName", name);
        return q.getResultList();
    }
    
    @Override
    public List <Library> findByPublished(String published) {
        Query q = em.createQuery(
        "SELECT b FROM Library b WHERE b.published LIKE :bookYear")
        .setParameter("bookYear", published);
        return q.getResultList();
    }
    
    @Override
    public List <Library> findByAuthor(String author) {
        Query q = em.createQuery(
        "SELECT b FROM Library b WHERE b.author LIKE :bookAuthor")
        .setParameter("bookAuthor", author);
        return q.getResultList();
    }
    
    @Override
    public List <Library> findByGenre(String genre) {
        Query q = em.createQuery(
        "SELECT b FROM Library b WHERE b.genre LIKE :bookGenre")
        .setParameter("bookGenre", genre);
        return q.getResultList();
    }
    
    
    @Override
    public List<Library> getAllBooks() {
        Query q = em.createQuery("SELECT b FROM Library b");
        return q.getResultList();
    }

    @Override
    public void updateBook(Library l) {
        em.merge(l);
    }

    @Override
    public void removeBook(Library l) {
        if (!em.contains(l)) {
            l = em.merge(l);
        }
        em.remove(l);
    }

    
}
