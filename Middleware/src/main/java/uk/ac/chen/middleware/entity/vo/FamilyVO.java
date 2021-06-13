package uk.ac.chen.middleware.entity.vo;

import lombok.Data;

/**
 * @author: Qiuyu
 */
@Data
public class FamilyVO {
    private Integer personId;
    private PersonVO personVO;
    private FamilyVO father;
    private FamilyVO mother;
}
