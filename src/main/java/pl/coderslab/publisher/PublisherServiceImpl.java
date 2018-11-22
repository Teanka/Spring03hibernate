package pl.coderslab.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public void save(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    @Override
    public void update(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    @Override
    public Optional<Publisher> find(Long id) {
        return publisherRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        publisherRepository.delete(publisherRepository.getOne(id));
    }

    @Override
    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    @Override
    public List<Publisher> findByNip(String nip) {
        return publisherRepository.findByNip(nip);
    }

    @Override
    public List<Publisher> findByRegon(String regon) {
        return publisherRepository.findByRegon(regon);
    }
}
