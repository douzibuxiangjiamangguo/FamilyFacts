package uk.ac.chen.middleware.entity;

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

    private Integer nameId;
    private Integer ownerId;
    private String surname;
    private String given;
    private String prefix;
    private String suffix;
    private String nickname;
    private Integer nameType;
    private String Date;
    private Integer sortDate;
    private Integer isPrimary;
    private Integer isPrivate;
    private Integer proof;
    private Float editDate;
    private String sentence;
    private String note;
    private Integer birthYear;
    private Integer deathYear;
}
