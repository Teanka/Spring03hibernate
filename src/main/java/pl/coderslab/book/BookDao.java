package pl.coderslab.book;

import java.util.List;

public interface BookDao {

    void save(Book book);

    void update(Book book);

    Book find(Long id);

    void delete(Long id);

    List<Book> findAll();

    List<Book> findPropositions();

    List<Book> getRatingList(int rating);


}
