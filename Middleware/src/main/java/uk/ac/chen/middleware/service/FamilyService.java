package uk.ac.chen.middleware.service;

import uk.ac.chen.middleware.entity.FamilyEntity;
import uk.ac.chen.middleware.entity.vo.FamilyVO;

/**
 * @author: Qiuyu
 */
public interface FamilyService {
    /**
     * Get family tree
     * @param personId
     * @return FamilyVO
     */
    FamilyVO getFamilyTreeByPersonId(Integer personId);

    /**
     * Get family by id
     * @param familyId
     * @return
     */
    FamilyEntity getFamilyByFamilyId(Integer familyId);
}
