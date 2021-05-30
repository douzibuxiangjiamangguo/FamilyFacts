package uk.ac.chen.middleware.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Qiuyu
 *
 * CREATE TABLE NameTable (NameID INTEGER PRIMARY KEY, OwnerID INTEGER, Surname TEXT,
 * Given TEXT, Prefix TEXT, Suffix TEXT, Nickname TEXT, NameType INTEGER, Date TEXT,
 * SortDate INTEGER, IsPrimary INTEGER, IsPrivate INTEGER, Proof INTEGER,
 * EditDate FLOAT, Sentence BLOB, Note BLOB, BirthYear INTEGER, DeathYear INTEGER);
 */
@Data
@TableName("NameTable")
public class NameEntity implements Serializable {

    private static final long serialVersionUID = 4868919946414959671L;

    @TableId("NameID")
    private Integer nameId;

    @TableField("OwnerID")
    private Integer ownerId;

    @TableField("Surname")
    private String surname;

    @TableField("Given")
    private String given;

    @TableField("Prefix")
    private String prefix;

    @TableField("Suffix")
    private String suffix;

    @TableField("Nickname")
    private String nickname;

    @TableField("NameType")
    private Integer nameType;

    @TableField("Date")
    private String date;

    @TableField("SortDate")
    private Integer sortDate;

    @TableField("IsPrimary")
    private Integer isPrimary;

    @TableField("IsPrivate")
    private Integer isPrivate;

    @TableField("Proof")
    private Integer proof;

    @TableField("EditDate")
    private Float editDate;

    @TableField("Sentence")
    private String sentence;

    @TableField("Note")
    private String note;

    @TableField("BirthYear")
    private Integer birthYear;

    @TableField("DeathYear")
    private Integer deathYear;
}
