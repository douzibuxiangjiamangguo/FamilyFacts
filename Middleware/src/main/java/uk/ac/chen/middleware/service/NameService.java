package uk.ac.chen.middleware.service;

import uk.ac.chen.middleware.entity.NameEntity;

import java.util.List;

/**
 * @author: Qiuyu
 */
public interface NameService {

    /**
     * Get name entity by full name
     * @param firstName first name
     * @param lastName last name
     * @return name list
     */
    List<NameEntity> getNameListByFullName(String firstName, String lastName);

    /**
     * Get name entity by person id
     * @param personId person id
     * @return NameEntity
     */
    NameEntity getNameEntityByPersonId(Integer personId);

    /**
     * Add name
     * @param nameEntity
     * @return
     */
    boolean addName(NameEntity nameEntity);
}
