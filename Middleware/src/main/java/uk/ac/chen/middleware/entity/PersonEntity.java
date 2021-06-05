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
 * CREATE TABLE PersonTable (PersonID INTEGER PRIMARY KEY, UniqueID TEXT,
 * Sex INTEGER, EditDate FLOAT, ParentID INTEGER, SpouseID INTEGER,
 * Color INTEGER, Relate1 INTEGER, Relate2 INTEGER, Flags INTEGER,
 * Living INTEGER, IsPrivate INTEGER, Proof INTEGER, Bookmark INTEGER, Note BLOB );
 */
@Data
@TableName("PersonTable")
public class PersonEntity implements Serializable{

    private static final long serialVersionUID = -5588317590401843397L;

    @TableId(value = "PersonID", type = IdType.AUTO)
    private Integer personId;

    @TableField("UniqueID")
    private String uniqueId;

    /**
     * 0 - male
     * 1 - female
     */
    @TableField("Sex")
    private Integer sex;

    @TableField("EditDate")
    private Float editDate;

    @TableField("ParentID")
    private Integer parentId;

    @TableField("SpouseID")
    private Integer spouseId;

    @TableField("Color")
    private Integer color;

    @TableField("Relate1")
    private Integer relate1;

    @TableField("Relate2")
    private Integer relate2;

    @TableField("Flags")
    private Integer flags;

    @TableField("Living")
    private Integer living;

    @TableField("IsPrivate")
    private Integer isPrivate;

    @TableField("Proof")
    private Integer proof;

    @TableField("Bookmark")
    private Integer bookmark;

    @TableField("Note")
    private String note;

}
