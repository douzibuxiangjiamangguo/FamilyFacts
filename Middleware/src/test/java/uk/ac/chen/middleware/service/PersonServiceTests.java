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
        String lastName = "person";
        Integer sex = 0;
        Integer birthYear = 1920;
        Integer deathYear = 2010;
        String address = "Newcastle";
        personService.addPerson(firstName, lastName, sex, birthYear, deathYear, address);
    }

    @Test
    void testAddSpouse() {
        Integer personId = 135;
        String firstName = "test";
        String lastName = "spouse";
        Integer sex = 1;
        Integer birthYear = 1920;
        Integer deathYear = 2010;
        String address = "Newcastle";
        personService.addSpouse(personId, firstName, lastName, sex, birthYear, deathYear, address);
    }

    @Test
    void testAddMother() {
        Integer personId = 135;
        String firstName = "test";
        String lastName = "mother";
        Integer sex = 1;
        Integer birthYear = 1890;
        Integer deathYear = 1970;
        String address = "Newcastle";
        personService.addMother(personId, firstName, lastName, sex, birthYear, deathYear, address);
    }

    @Test
    void testAddFather() {
        Integer personId = 135;
        String firstName = "test";
        String lastName = "father";
        Integer sex = 0;
        Integer birthYear = 1890;
        Integer deathYear = 1970;
        String address = "Newcastle";
        personService.addFather(personId, firstName, lastName, sex, birthYear, deathYear, address);
    }

    @Test
    void testSearchPerson() {
        String firstName = "test";
        String lastName = "add2";
        PersonEntity personEntity = personService.getPersonByFullName(firstName, lastName);
        logger.info("personEntity: {}", personEntity);
    }

    @Test
    void testSearchPersonById() {
        int personId = 135;
        PersonVO personVO = personService.getPersonVOById(personId);
        logger.info("personVo: {}", personVO);
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
        int res = personService.deletePersonById(138);
        personService.deletePersonById(137);
        personService.deletePersonById(136);
        personService.deletePersonById(135);
        logger.info("delete person : {}", res);
    }

}
