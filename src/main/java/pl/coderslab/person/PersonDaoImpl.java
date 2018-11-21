package pl.coderslab.person;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Person person) {
      entityManager.persist(person);
    }

    @Override
    public void update(Person person) {
        entityManager.merge(entityManager.contains(person) ?
                person : entityManager.merge(person));
    }

    @Override
    public Person find(Long id) {
        return entityManager.find(Person.class, id);
    }

    @Override
    public void delete(Long id) {
        Person person = find(id);
        if(person!=null){
            entityManager.remove(person);
        }
    }

    @Override
    public List<Person> findAll() {
        Query query = entityManager.createQuery("SELECT b FROM Person b");
        return query.getResultList();
    }
}
