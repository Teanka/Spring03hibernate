package pl.coderslab.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PublisherServiceImpl implements PublisherService{

    @Autowired
    private PublisherDao publisherDao;

    @Override
    public List<Publisher> findAll() {
        return publisherDao.findAll();
    }
}
