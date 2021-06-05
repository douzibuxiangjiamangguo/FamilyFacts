package uk.ac.chen.middleware.service;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import uk.ac.chen.middleware.entity.PersonEntity;
import uk.ac.chen.middleware.entity.vo.PersonVO;
import uk.ac.chen.middleware.mapper.PersonMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: Qiuyu
 */

@SpringBootTest
public class PersonServiceTests {

    private static final Logger logger = LoggerFactory.getLogger(PersonServiceTests.class);

    @Resource
    private PersonService personService;

    @Resource
    private PersonMapper personMapper;

    @Test
    void testAddPerson() {
        String firstName = "test";
        String lastName = "add2";
        Integer sex = 0;
        Integer birthYear = 1930;
        Integer deathYear = 2020;
        String address = "Newcastle";
        personService.addPerson(firstName, lastName, sex, birthYear, deathYear, address);
    }

    @Test
    void testSearchPerson() {
        String firstName = "test";
        String lastName = "add2";
        PersonEntity personEntity = personService.getPersonByFullName(firstName, lastName);
        logger.info("person: {}", personEntity);
    }

    @Test
    void testListPersons() {
        List<PersonEntity> persons = personService.listPersons();
        for (PersonEntity person : persons) {
            logger.info("person: {}", person);
            PersonVO personVO = personService.getPersonVOById(person.getPersonId());
            logger.info("personVo: {}", personVO);
        }
    }

    @Test
    void testDeletePerson() {
        int personId = 136;
        int res = personService.deletePersonById(personId);
        logger.info("delete person : {}", res);
    }

}
