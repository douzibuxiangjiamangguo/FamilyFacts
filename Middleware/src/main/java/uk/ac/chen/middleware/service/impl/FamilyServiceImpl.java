package uk.ac.chen.middleware.service.impl;

import org.springframework.stereotype.Service;
import uk.ac.chen.middleware.entity.FamilyEntity;
import uk.ac.chen.middleware.entity.PersonEntity;
import uk.ac.chen.middleware.entity.vo.FamilyVO;
import uk.ac.chen.middleware.entity.vo.PersonVO;
import uk.ac.chen.middleware.mapper.FamilyMapper;
import uk.ac.chen.middleware.service.FamilyService;
import uk.ac.chen.middleware.service.PersonService;

import javax.annotation.Resource;

/**
 * @author: Qiuyu
 */
@Service("FamilyService")
public class FamilyServiceImpl implements FamilyService {

    @Resource
    private PersonService personService;

    @Resource
    private FamilyMapper familyMapper;

    @Override
    public FamilyVO getFamilyTreeByPersonId(Integer personId) {
        FamilyVO root = getFamilyNode(personId);
        dfs(root);
        return root;
    }

    private void dfs(FamilyVO root) {
        if (root == null) {
            return;
        }
        PersonEntity personEntity = personService.getPersonById(root.getPersonId());
        FamilyEntity familyEntity = getFamilyByFamilyId(personEntity.getParentId());
        if (familyEntity == null) {
            return;
        }
        if (familyEntity.getFatherId() != null) {
            root.setFather(getFamilyNode(familyEntity.getFatherId()));
            dfs(root.getFather());
        }
        if (familyEntity.getMotherId() != null) {
            root.setMother(getFamilyNode(familyEntity.getMotherId()));
            dfs(root.getMother());
        }
    }

    private FamilyVO getFamilyNode(Integer personId) {
        PersonVO personVO = personService.getPersonVOById(personId);
        if (personVO.getPersonId() == null) {
            return new FamilyVO();
        }
        FamilyVO node = new FamilyVO();
        node.setPersonId(personId);
        node.setPersonVO(personVO);
        return node;
    }

    @Override
    public FamilyEntity getFamilyByFamilyId(Integer familyId) {
        return familyMapper.selectById(familyId);
    }
}
