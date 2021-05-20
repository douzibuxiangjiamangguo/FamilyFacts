package uk.ac.chen.middleware.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Qiuyu
 * CREATE TABLE CitationTable (CitationID INTEGER PRIMARY KEY, OwnerType INTEGER,
 * SourceID INTEGER, OwnerID INTEGER, Quality TEXT, IsPrivate INTEGER,
 * Comments BLOB, ActualText BLOB, RefNumber TEXT, Flags INTEGER, Fields BLOB);
 */
@Data
@TableName("CitationTable")
public class CitationEntity implements Serializable {

    private static final long serialVersionUID = -2186216117224893938L;

    private Integer citationID;
    private Integer ownerType;
    private Integer sourceId;
    private Integer ownerId;
    private String quality;
    private Integer isPrivate;
    private String comments;
    private String actualText;
    private String refNumber;
    private Integer flags;
    private String fields;
}
