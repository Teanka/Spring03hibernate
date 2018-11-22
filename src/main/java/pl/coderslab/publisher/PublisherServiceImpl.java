package pl.coderslab.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private PublisherDao publisherDao;

    @Override
    public void save(Publisher publisher) {
        publisherDao.save(publisher);
    }

    @Override
    public void update(Publisher publisher) {
        publisherDao.update(publisher);
    }

    @Override
    public Publisher find(Long id) {
        return publisherDao.find(id);
    }

    @Override
    public void delete(Long id) {
        publisherDao.delete(id);
    }

    @Override
    public List<Publisher> findAll() {
        return publisherDao.findAll();
    }
}
