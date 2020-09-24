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
    public List<Library> getAllBooks() {
        Query q = em.createQuery("SELECT b FROM Burger b");
        return q.getResultList();
    }

    @Override
    public void updateBook(Library l) {
        em.merge(l);
    }

    @Override
    public void removeBook(Library l) {
        if(!em.contains(l)){
            l = em.merge(l);
        }
        em.remove(l);
    }

    
}
