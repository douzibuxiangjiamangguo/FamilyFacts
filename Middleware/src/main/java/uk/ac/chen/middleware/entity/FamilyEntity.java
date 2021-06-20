package uk.ac.chen.middleware.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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

    @TableId(value = "FamilyID", type = IdType.AUTO)
    private Integer familyId;

    @TableField("FatherID")
    private Integer fatherId;

    @TableField("MotherID")
    private Integer motherId;

    @TableField("ChildID")
    private Integer childId;

    @TableField("HusbOrder")
    private Integer husbOrder;

    @TableField("WifeOrder")
    private Integer wifeOrder;

    @TableField("IsPrivate")
    private Integer isPrivate;

    @TableField("Proof")
    private Integer proof;

    @TableField("SpouseLabel")
    private Integer spouseLabel;

    @TableField("FatherLabel")
    private Integer fatherLabel;

    @TableField("MotherLabel")
    private Integer motherLabel;

    @TableField("Note")
    private String note;

}
