package uk.ac.chen.middleware.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Qiuyu
 *
 * CREATE TABLE ChildTable (RecID INTEGER PRIMARY KEY, ChildID INTEGER, FamilyID INTEGER,
 * RelFather INTEGER, RelMother INTEGER, ChildOrder INTEGER,
 * IsPrivate INTEGER, ProofFather INTEGER, ProofMother INTEGER, Note BLOB);
 */
@Data
@TableName("ChildTable")
public class ChildEntity implements Serializable {

    private static final long serialVersionUID = 7162394071168265126L;

    private Integer recId;
    private Integer childId;
    private Integer familyId;
    private Integer relFather;
    private Integer relMother;
    private Integer childOrder;
    private Integer isPrivate;
    private Integer proofFather;
    private Integer proofMother;
    private String note;
}
