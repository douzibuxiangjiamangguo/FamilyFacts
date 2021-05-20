package uk.ac.chen.middleware.entity;

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

    private Integer personId;
    private String uniqueId;
    private Integer sex;
    private Float editData;
    private Integer parentId;
    private Integer spouseId;
    private Integer color;
    private Integer relate1;
    private Integer relate2;
    private Integer flags;
    private Integer living;
    private Integer isPrivate;
    private Integer proof;
    private Integer bookmark;
    private String note;

}
