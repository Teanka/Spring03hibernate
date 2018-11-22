package pl.coderslab.publisher;

import org.springframework.stereotype.Repository;
import pl.coderslab.book.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PublisherDaoImpl implements PublisherDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Publisher publisher) {
        entityManager.persist(publisher);
    }

    @Override
    public void update(Publisher publisher) {
        entityManager.merge(entityManager.contains(publisher) ?
                publisher : entityManager.merge(publisher));
    }

    @Override
    public Publisher find(Long id) {
        return entityManager.find(Publisher.class,id);
    }

    @Override
    public void delete(Long id) {
        Publisher publisher = find(id);
        if (publisher != null) {
            entityManager.remove(publisher);
        }
    }

    @Override
    public List<Publisher> findAll() {
        Query query = entityManager.createQuery("select p from Publisher p");
        return query.getResultList();
    }
}
