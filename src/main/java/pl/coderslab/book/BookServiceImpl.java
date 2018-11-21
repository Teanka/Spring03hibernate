package pl.coderslab.book;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public void save(Book book) {
        bookDao.save(book);
    }

    @Override
    public void update(Book book) {
        bookDao.update(book);
    }

    @Override
    public Book find(Long id) {
        return bookDao.find(id);
    }

    @Override
    public Book findWithAuthors(Long id) {
        Book book = bookDao.find(id);
        Hibernate.initialize(book.getAuthors());
        return book;
    }

    @Override
    public void delete(Long id) {
        bookDao.delete(id);
    }

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public List<Book> getRatingList(int rating) {
        return bookDao.getRatingList(rating);
    }
}
