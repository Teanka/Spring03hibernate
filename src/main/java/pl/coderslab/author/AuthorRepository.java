package pl.coderslab.author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository <Author,Long>{
    Author findByEmail(String email);
    Author findByPesel(String pesel);
    List<Author> findByLastName(String lastName);

    @Query("select a from Author a where a.email LIKE ?1%" )
    List<Author> getAuthorsByEmailStart(String emailStartsWith);

    @Query("select a from Author a where a.pesel LIKE ?1%")
    List<Author> getAuthorsByPeselsStart(String peselStarts);
}


//    Listę autorów, których email zaczyna się od wskazanego ciągu znaków.
//        Listę autorów których pesel zaczyna się od wskazanych znaków, np 83.
//    Utwórz repozytorium dla klasy Author.
//        Utwórz metody pobierające:
//        Autora dla zadanego email,
//        Autora dla zadanego peselu,
//        Listę autorów o zadanym nazwisku.