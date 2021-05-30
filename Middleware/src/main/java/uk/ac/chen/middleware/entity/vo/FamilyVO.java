package uk.ac.chen.middleware.entity.vo;

import lombok.Data;
import uk.ac.chen.middleware.entity.NameEntity;

/**
 * @author: Qiuyu
 */
@Data
public class FamilyVO {
    private Integer personId;
    private FamilyVO father;
    private FamilyVO mother;
    private NameEntity fullName;
}
