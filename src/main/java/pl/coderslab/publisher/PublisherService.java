package pl.coderslab.publisher;

import java.util.List;
import java.util.Optional;

public interface PublisherService {

    void save(Publisher publisher);

    void update(Publisher publisher);

    Optional<Publisher> find(Long id);

    void delete(Long id);

    List<Publisher> findAll();

    List<Publisher> findByNip(String nip);

    List<Publisher> findByRegon(String regon);
}
