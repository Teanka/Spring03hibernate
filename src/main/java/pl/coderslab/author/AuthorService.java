package pl.coderslab.author;

import java.util.List;

public interface AuthorService {

    void save(Author author);

    void update(Author author);

    Author find(Long id);

    void delete(Long id);

    List<Author> findAll();
}
