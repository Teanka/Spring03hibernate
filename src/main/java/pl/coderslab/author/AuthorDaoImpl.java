package pl.coderslab.author;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class AuthorDaoImpl implements AuthorDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Author author) {
        entityManager.persist(author);
    }

    @Override
    public void update(Author author) {
        entityManager.merge(author);
    }

    @Override
    public Author find(Long id) {
        return entityManager.find(Author.class, id);
    }

    @Override
    public void delete(Long id) {
        Author author = find(id);
        if (author != null) {
            entityManager.remove(author);
        }
    }

    @Override
    public List<Author> findAll() {
        Query query = entityManager.createQuery("select a from Author a");
        List authors = query.getResultList();
        return authors;
    }
}
