package uk.ac.chen.middleware.controller;

import org.springframework.web.bind.annotation.*;
import uk.ac.chen.middleware.entity.PersonEntity;
import uk.ac.chen.middleware.entity.results.JsonResult;
import uk.ac.chen.middleware.entity.results.Result;
import uk.ac.chen.middleware.entity.results.ResultCode;
import uk.ac.chen.middleware.service.PersonService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: Qiuyu
 */
@RestController
@RequestMapping("person/")
public class PersonController {
    @Resource
    private PersonService personService;

    @GetMapping("search")
    public JsonResult<PersonEntity> getPersonByFullName(@RequestParam("first_name") String firstName,
                                                        @RequestParam("last_name") String lastName) {
        PersonEntity personEntity = personService.getPersonByFullName(firstName, lastName);
        if (personEntity == null || personEntity.getPersonId() == null) {
            return Result.fail(ResultCode.PERSON_NOT_FOUND);
        } else {
            return Result.success(personEntity);
        }
    }

    @GetMapping("search/{person_id}")
    public JsonResult<PersonEntity> getPersonById(@PathVariable("person_id") Integer personId) {
        PersonEntity personEntity = personService.getPersonById(personId);
        if (personEntity == null || personEntity.getPersonId() == null) {
            return Result.fail(ResultCode.PERSON_NOT_FOUND);
        } else {
            return Result.success(personEntity);
        }
    }

    @GetMapping("list")
    public JsonResult<List<PersonEntity>> listPersons() {
        List<PersonEntity> persons = personService.listPersons();
        return Result.success(persons);
    }
}
