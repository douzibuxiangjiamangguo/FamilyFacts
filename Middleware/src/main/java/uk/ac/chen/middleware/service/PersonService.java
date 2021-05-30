package uk.ac.chen.middleware.service;

import uk.ac.chen.middleware.entity.PersonEntity;

import java.util.List;

/**
 * @author: Qiuyu
 */
public interface PersonService {

    /**
     * Add a person
     * @param person person entity
     * @return Ture if successful
     */
    boolean addPerson(PersonEntity person);

    /**
     * Get person by full name
     * @param firstName first name
     * @param lastName last name
     * @return person entity
     */
    PersonEntity getPersonByFullName(String firstName, String lastName);

    /**
     * Get person by id
     * @param personId id
     * @return person entity
     */
    PersonEntity getPersonById(Integer personId);

    /**
     * List All persons
     * @return
     */
    List<PersonEntity> listPersons();
}
