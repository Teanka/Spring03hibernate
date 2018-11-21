package pl.coderslab.book;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Book book) {
        entityManager.persist(book);
    }

    @Override
    public void update(Book book) {
        entityManager.merge(book);
    }

    @Override
    public Book find(Long id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public void delete(Long id) {
        Book book = find(id);
        if (book != null) {
            entityManager.remove(book);
        }
    }

    @Override
    public List<Book> findAll() {
        Query query = entityManager.createQuery("select b from Book b");
        List books = query.getResultList();
        return books;
    }

    @Override
    public List<Book> getRatingList(int rating) {
        Query query = entityManager.createQuery("select b from Book b where rating = :rating");
        query.setParameter("rating", rating);
        return query.getResultList();
    }
}
