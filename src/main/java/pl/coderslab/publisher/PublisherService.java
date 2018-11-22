package pl.coderslab.publisher;

import java.util.List;

public interface PublisherService {

    void save(Publisher publisher);

    void update(Publisher publisher);

    Publisher find(Long id);

    void delete(Long id);

    List<Publisher> findAll();
}
