package pl.coderslab.covnerter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Publisher;

public class PublisherConverter implements Converter<String, Publisher> {
   
	@Autowired
    private  PublisherDao publisherDao;
    
	@Override
    public Publisher convert(String id) {
		Publisher publisher = publisherDao.findById(Long.parseLong(id));
        return  publisher;
    }
}