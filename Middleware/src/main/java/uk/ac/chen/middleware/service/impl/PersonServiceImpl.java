package uk.ac.chen.middleware.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import uk.ac.chen.middleware.entity.*;
import uk.ac.chen.middleware.entity.vo.PersonVO;
import uk.ac.chen.middleware.mapper.*;
import uk.ac.chen.middleware.service.FamilyService;
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

    @Resource
    private NameMapper nameMapper;

    @Resource
    private AddressMapper addressMapper;

    @Resource
    private AddressLinkMapper addressLinkMapper;

    @Resource
    private FamilyService familyService;

    @Resource
    private FamilyMapper familyMapper;

    @Override
    public int addPerson(String firstName, String lastName, Integer sex,
                         Integer birthYear, Integer deathYear, String address) {

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setName(address);
        addressMapper.insert(addressEntity);

        PersonEntity personEntity = new PersonEntity();
        personEntity.setSex(sex);
        personEntity.setLiving(addressEntity.getAddressId());
        personMapper.insert(personEntity);
        int personId = personEntity.getPersonId();

        AddressLinkEntity addressLinkEntity = new AddressLinkEntity();
        addressLinkEntity.setAddressId(addressEntity.getAddressId());
        addressLinkEntity.setOwnerId(personId);
        addressLinkMapper.insert(addressLinkEntity);

        nameService.addName(new NameEntity(firstName, lastName, personId, birthYear, deathYear));
        return personId;
    }

    @Override
    public int addSpouse(Integer personId, String firstName, String lastName, Integer sex,
                         Integer birthYear, Integer deathYear, String address) {
        int spouseId = addPerson(firstName, lastName, sex,birthYear, deathYear, address);
        PersonEntity personEntity = getPersonById(personId);
        if (personEntity == null || !personEntity.getPersonId().equals(personId)) {
            return -1;
        }
        personEntity.setSpouseId(spouseId);
        personMapper.updateById(personEntity);

        PersonEntity spouseEntity = getPersonById(spouseId);
        spouseEntity.setSpouseId(personId);
        personMapper.updateById(spouseEntity);
        return spouseId;
    }

    @Override
    public int addFather(Integer personId, String firstName, String lastName, Integer sex,
                         Integer birthYear, Integer deathYear, String address) {
        int fatherId = addPerson(firstName, lastName, sex, birthYear, deathYear, address);
        PersonEntity personEntity = getPersonById(personId);
        if (personEntity == null || !personEntity.getPersonId().equals(personId)) {
            return -1;
        }

        FamilyEntity familyEntity;
        if (personEntity.getParentId() == null) {
            familyEntity = new FamilyEntity();
            familyEntity.setFatherId(fatherId);
            familyMapper.insert(familyEntity);

            personEntity.setParentId(familyEntity.getFamilyId());
            personMapper.updateById(personEntity);
        } else {
            familyEntity = familyService.getFamilyByFamilyId(personEntity.getParentId());
            familyEntity.setFatherId(fatherId);
            familyMapper.updateById(familyEntity);
        }
        return familyEntity.getFamilyId();
    }

    @Override
    public int addMother(Integer personId, String firstName, String lastName, Integer sex,
                         Integer birthYear, Integer deathYear, String address) {
        int motherId = addPerson(firstName, lastName, sex,birthYear, deathYear, address);
        PersonEntity personEntity = getPersonById(personId);
        if (personEntity == null || !personEntity.getPersonId().equals(personId)) {
            return -1;
        }

        FamilyEntity familyEntity;
        if (personEntity.getParentId() == null) {
            familyEntity = new FamilyEntity();
            familyEntity.setMotherId(motherId);
            familyMapper.insert(familyEntity);

            personEntity.setParentId(familyEntity.getFamilyId());
            personMapper.updateById(personEntity);
        } else {
            familyEntity = familyService.getFamilyByFamilyId(personEntity.getParentId());
            familyEntity.setMotherId(motherId);
            familyMapper.updateById(familyEntity);
        }
        return familyEntity.getFamilyId();
    }

    @Override
    public PersonEntity getPersonByFullName(String firstName, String lastName) {
        NameEntity nameEntity = nameService.getNameEntityByFullName(firstName, lastName);
        if (nameEntity == null || nameEntity.getOwnerId() == null) {
            return new PersonEntity();
        }
        return getPersonById(nameEntity.getOwnerId());
    }

    @Override
    public PersonEntity getPersonById(Integer personId) {
        return personMapper.selectById(personId);
    }

    @Override
    public PersonVO getPersonVOById(Integer personId) {
        PersonEntity person = getPersonById(personId);
        if (person == null) {
            return new PersonVO();
        }
        NameEntity fullName = nameService.getNameEntityByPersonId(personId);
        String sex = person.getSex() == 0 ? "female" : "male";
        AddressEntity addressEntity = addressMapper.selectById(person.getLiving());
        String address = addressEntity == null ? " " : addressEntity.getName();
        if (fullName == null) {
            return new PersonVO(personId, " ", " ", sex, 0, 0, address);
        }
        Integer birth = fullName.getBirthYear() == null ? 0 : fullName.getBirthYear();
        Integer death = fullName.getDeathYear() == null ? 0 : fullName.getDeathYear();
        PersonVO personVo = new PersonVO(personId, fullName.getGiven(), fullName.getSurname(), sex,
                birth, death, address);
        return personVo;
    }

    @Override
    public List<PersonEntity> listPersons() {
        return personMapper.selectList(null);
    }

    @Override
    public int deletePersonById(Integer personId) {
        PersonEntity personEntity = getPersonById(personId);
        NameEntity nameEntity = nameService.getNameEntityByPersonId(personId);
        if (nameEntity != null && nameEntity.getNameId() != null) {
            nameMapper.deleteById(nameEntity.getNameId());
        }
        if (personEntity != null && personEntity.getLiving() != null) {
            addressMapper.deleteById(personEntity.getLiving());
        }

        if (personEntity != null && personEntity.getSpouseId() != null) {
            PersonEntity spouse = getPersonById(personEntity.getSpouseId());
            if (spouse != null) {
                spouse.setSpouseId(null);
                personMapper.updateById(spouse);
            }
        }

        if (personEntity != null && personEntity.getParentId() != null) {
            familyMapper.deleteById(personEntity.getParentId());
        }

        QueryWrapper<FamilyEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("FatherID", personId);
        List<FamilyEntity> families = familyMapper.selectList(queryWrapper);
        if (families.size() > 0) {
            for (FamilyEntity family : families) {
                family.setFatherId(null);
                familyMapper.updateById(family);
            }
        }

        queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("MotherID", personId);
        families = familyMapper.selectList(queryWrapper);
        if (families.size() > 0) {
            for (FamilyEntity family : families) {
                family.setMotherId(null);
                familyMapper.updateById(family);
            }
        }

        return personMapper.deleteById(personId);
    }
}
