package pl.coderslab.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.category.Category;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findByTitle(String title);

    @Query("select b from Book b where b.title =:title")
    List<Book> getBooksByTitle(@Param("title") String title);

    List<Book> findByCategoryName(String categoryName);

    @Query("Select b from Book b where b.category.name =?1")
    List<Book> getBooksByCategoryName(String categoryName);

    List<Book> findByCategoryId(Long categoryId);
    List<Book> findByAuthorsFirstNameAndAuthorsLastName(String authorFirstName, String authorLastName);
    List<Book> findByPublisherName(String publisherName);
    List<Book> findByRating(int rating);
    Book findFirstByCategoryNameOrderByTitle(String categoryName); //containingIgnoreCase

    @Query("Select b from Book b where b.rating BETWEEN ?1 AND ?2")
    List<Book> getBooksByRatingBetween3and5(int first, int second);

    @Query("SELECT b from Book b where b.publisher.name =?1")
    List<Book> getBooksByPublishersName(String publisherName);

//    @Query("Select b from Book b where b.category.name=?1 order by b.title")
    @Query(value="select * from BOOKS b join CATEGORIES c on b.category_id = c.id where c.name = ?1 ORDER BY b.title LIMIT 1",  nativeQuery = true)
    Book getFirstBookByCategoryNameTitleSorting(String categoryName);
}

//    Listę książek dla których rating jest pomiędzy zadanymi parametrami np. między 3 a 5.
//
//        Listę książek dla zadanego wydawcy.
//
//        Pierwszą książkę z zadanej kategorii, z sortowaniem po tytule.
//    Listę książek dla zadanego autora.
//        Listę książek dla zadanego wydawcy
//        Listę książek dla określonego ratingu
//        Pierwszą książkę z zadanej kategorii, z sortowaniem po tytule.