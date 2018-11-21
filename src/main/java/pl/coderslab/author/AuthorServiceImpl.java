package pl.coderslab.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDao authorDao;

    @Override
    public void save(Author author) {
        authorDao.save(author);
    }

    @Override
    public void update(Author author) {
        authorDao.update(author);
    }

    @Override
    public Author find(Long id) {
        return authorDao.find(id);
    }

    @Override
    public void delete(Long id) {
        authorDao.delete(id);
    }

    @Override
    public List<Author> findAll() {
        return authorDao.findAll();
    }
}
