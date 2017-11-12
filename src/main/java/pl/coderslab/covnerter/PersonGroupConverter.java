package pl.coderslab.covnerter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.dao.PersonGroupDao;
import pl.coderslab.entity.PersonGroup;

public class PersonGroupConverter implements Converter<String, PersonGroup> {
   
	@Autowired
    private  PersonGroupDao personGroupDao;
    
	@Override
    public PersonGroup convert(String id) {
        PersonGroup group = personGroupDao.findById(Long.parseLong(id));
        return  group;
    }
}