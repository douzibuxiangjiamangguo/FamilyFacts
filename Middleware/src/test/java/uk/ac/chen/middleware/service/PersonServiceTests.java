package uk.ac.chen.middleware.service;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import uk.ac.chen.middleware.entity.PersonEntity;

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

    @Test
    void testAddPerson() {

    }

    @Test
    void testSearchPerson() {
        String firstName = "Hedwig";
        String lastName = "Holtz";
        PersonEntity personEntity = personService.getPersonByFullName(firstName, lastName);
        logger.info("person: {}", personEntity);
    }

    @Test
    void testListPersons() {
        List<PersonEntity> persons = personService.listPersons();
        for (PersonEntity person : persons) {
            logger.info("person: {}", person);
        }
    }

}
