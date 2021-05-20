package uk.ac.chen.middleware.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Qiuyu
 *
 * CREATE TABLE FamilyTable (FamilyID INTEGER PRIMARY KEY, FatherID INTEGER,
 * MotherID INTEGER, ChildID INTEGER, HusbOrder INTEGER, WifeOrder INTEGER,
 * IsPrivate INTEGER, Proof INTEGER, SpouseLabel INTEGER, FatherLabel INTEGER,
 * MotherLabel INTEGER, Note BLOB );
 */
@Data
@TableName("FamilyTable")
public class FamilyEntity implements Serializable {

    private static final long serialVersionUID = 4070895159713354526L;

    private Integer familyId;
    private Integer fatherId;
    private Integer motherId;
    private Integer childId;
    private Integer husbOrder;
    private Integer wifeOrder;
    private Integer isPrivate;
    private Integer proof;
    private Integer spouseLabel;
    private Integer fatherLabel;
    private Integer motherLabel;
    private String note;

}
