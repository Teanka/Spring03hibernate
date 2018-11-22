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

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void update(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book find(Long id) {
        return bookRepository.getOne(id);//bądź findById
    }

    @Override
    public Book findWithAuthors(Long id) {
        Book book = find(id);
        Hibernate.initialize(book.getAuthors());
        return book;
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findPropositions() {
        return bookDao.findPropositions();
    }

    @Override
    public List<Book> getRatingList(int rating) {
        return bookDao.getRatingList(rating);
    }

    @Override
    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public List<Book> findByCategoryName(String categoryName) {
        return bookRepository.findByCategoryName(categoryName);
    }

    @Override
    public List<Book> findByCategoryId(Long categoryId) {
        return bookRepository.findByCategoryId(categoryId);
    }

    @Override
    public List<Book> findByAuthorsFirstAndLastName(String firstName, String lastName) {
        return bookRepository.findByAuthorsFirstNameAndAuthorsLastName(firstName,lastName);
    }

    @Override
    public List<Book> findByPublisherName(String publisherName) {
        return bookRepository.findByPublisherName(publisherName);
    }

    @Override
    public List<Book> findByRating(int rating) {
        return bookRepository.findByRating(rating);
    }

    @Override
    public Book findBookByCategoryNameTitle(String categoryName) {
        return bookRepository.findFirstByCategoryNameOrderByTitle(categoryName);
    }


}
