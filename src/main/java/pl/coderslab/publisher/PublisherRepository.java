package pl.coderslab.publisher;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublisherRepository extends JpaRepository<Publisher,Long> {
    List<Publisher> findByNip(String nip);
    List<Publisher> findByRegon(String regon);

//    Utwórz repozytorium dla klasy Publisher.
//    Utwórz metody pobierające:
//    Wydawcę dla zadanego nipu,
//    Wydawcę dla zadanego regonu.
}
