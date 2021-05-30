package uk.ac.chen.middleware.entity.vo;

import lombok.Data;
import uk.ac.chen.middleware.entity.NameEntity;

/**
 * @author: Qiuyu
 */
@Data
public class PersonVO {

    private String personId;
    private NameEntity father;
    private NameEntity mother;
    private NameEntity fullName;

}
