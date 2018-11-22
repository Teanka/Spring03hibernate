package pl.coderslab.publisher;

import pl.coderslab.book.Book;

import java.util.List;

public interface PublisherDao {

        void save(Publisher publisher);

        void update(Publisher publisher);

        Publisher find(Long id);

        void delete(Long id);

        List<Publisher> findAll();

}
