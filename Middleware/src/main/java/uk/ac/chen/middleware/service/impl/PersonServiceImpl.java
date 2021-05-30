package uk.ac.chen.middleware.service.impl;

import org.springframework.stereotype.Service;
import uk.ac.chen.middleware.entity.NameEntity;
import uk.ac.chen.middleware.entity.PersonEntity;
import uk.ac.chen.middleware.mapper.PersonMapper;
import uk.ac.chen.middleware.service.NameService;
import uk.ac.chen.middleware.service.PersonService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: Qiuyu
 */
@Service("PersonService")
public class PersonServiceImpl implements PersonService {

    @Resource
    private PersonMapper personMapper;

    @Resource
    private NameService nameService;

    @Override
    public boolean addPerson(PersonEntity person) {
        return personMapper.insert(person) > 0;
    }

    @Override
    public PersonEntity getPersonByFullName(String firstName, String lastName) {
        NameEntity nameEntity = nameService.getNameEntityByFullName(firstName, lastName);
        return getPersonById(nameEntity.getOwnerId());
    }

    @Override
    public PersonEntity getPersonById(Integer personId) {
        return personMapper.selectById(personId);
    }

    /**
     * List All persons
     *
     * @return
     */
    @Override
    public List<PersonEntity> listPersons() {
        return personMapper.selectList(null);
    }
}
