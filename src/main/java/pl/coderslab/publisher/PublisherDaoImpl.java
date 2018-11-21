package pl.coderslab.publisher;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PublisherDaoImpl implements PublisherDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Publisher> findAll() {
        Query query = entityManager.createQuery("select p from Publisher p");
        return query.getResultList();
    }
}
