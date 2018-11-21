package pl.coderslab.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    public void save(Person person) {
        personDao.save(person);
    }

    @Override
    public void update(Person person) {
        personDao.update(person);
    }

    @Override
    public Person find(Long id) {
        return personDao.find(id);
    }

    @Override
    public void delete(Long id) {
        personDao.delete(id);
    }

    @Override
    public List<Person> findAll() {
        return personDao.findAll();
    }
}
