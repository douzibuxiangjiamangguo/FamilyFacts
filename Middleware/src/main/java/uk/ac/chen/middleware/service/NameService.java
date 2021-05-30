package uk.ac.chen.middleware.service;

import uk.ac.chen.middleware.entity.NameEntity;

/**
 * @author: Qiuyu
 */
public interface NameService {

    /**
     * Get name entity by full name
     * @param firstName first name
     * @param lastName last name
     * @return name entity
     */
    NameEntity getNameEntityByFullName(String firstName, String lastName);

    /**
     * Get name entity by person id
     * @param personId person id
     * @return NameEntity
     */
    NameEntity getNameEntityByPersonId(Integer personId);
}
