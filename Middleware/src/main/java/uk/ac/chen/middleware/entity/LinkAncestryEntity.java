package uk.ac.chen.middleware.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Qiuyu
 * CREATE TABLE LinkAncestryTable (LinkID INTEGER PRIMARY KEY, extSystem INTEGER, LinkType
 * INTEGER, rmID INTEGER, extID TEXT, Modified INTEGER, extVersion TEXT, extDate FLOAT,
 * Status INTEGER, Note BLOB);
 */
@Data
@TableName("LinkAncestryTable")
public class LinkAncestryEntity implements Serializable {

    private static final long serialVersionUID = 5013477658208368726L;

    private Integer linkId;
    private Integer extSystem;
    private Integer linkType;
    private Integer rmId;
    private String extId;
    private Integer modified;
    private String extVersion;
    private Float extDate;
    private Integer Status;
    private String note;
}
