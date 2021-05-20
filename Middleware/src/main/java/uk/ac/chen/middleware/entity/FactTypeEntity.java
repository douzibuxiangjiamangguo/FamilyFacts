package uk.ac.chen.middleware.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Qiuyu
 * CREATE TABLE FactTypeTable (FactTypeID INTEGER PRIMARY KEY, OwnerType INTEGER, Name TEXT,
 * Abbrev TEXT, GedcomTag TEXT, UseValue INTEGER, UseDate INTEGER, UsePlace INTEGER,
 * Sentence BLOB, Flags INTEGER );
 */
@Data
@TableName("FactTypeTable")
public class FactTypeEntity implements Serializable {

    private static final long serialVersionUID = -8007226078323599377L;

    private Integer factTypeId;
    private Integer ownerType;
    private String name;
    private String abbrev;
    private String gedcomTag;
    private Integer useValue;
    private Integer useDate;
    private Integer usePlace;
    private String sentence;
    private Integer flags;
}
