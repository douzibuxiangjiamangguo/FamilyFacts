package uk.ac.chen.middleware.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.chen.middleware.entity.results.JsonResult;
import uk.ac.chen.middleware.entity.results.Result;
import uk.ac.chen.middleware.entity.results.ResultCode;
import uk.ac.chen.middleware.entity.vo.FamilyVO;
import uk.ac.chen.middleware.service.FamilyService;

import javax.annotation.Resource;

/**
 * @author: Qiuyu
 */
@RestController
@RequestMapping("family/")
public class FamilyController {
    @Resource
    private FamilyService familyService;

    @GetMapping("tree/{person_id}")
    public JsonResult<FamilyVO> getFamilyTreeByPersonId(@PathVariable("person_id") Integer personId) {
        if (personId == null) {
            return Result.fail(ResultCode.PARAM_NOT_VALID);
        }
        FamilyVO familyTree = familyService.getFamilyTreeByPersonId(personId);
        if (familyTree == null || familyTree.getPersonId() == null) {
            return Result.fail(ResultCode.PERSON_NOT_FOUND);
        } else {
            return Result.success(familyTree);
        }
    }
}
