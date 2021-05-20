package uk.ac.chen.middleware.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Qiuyu
 * CREATE TABLE SourceTable (SourceID INTEGER PRIMARY KEY, Name TEXT, RefNumber TEXT,
 * ActualText TEXT, Comments TEXT, IsPrivate INTEGER, TemplateID INTEGER, Fields BLOB);
 */
@Data
@TableName("SourceTable")
public class SourceEntity implements Serializable {

    private static final long serialVersionUID = 3781523419839554308L;

    private Integer sourceId;
    private String name;
    private String refNumber;
    private String actualText;
    private String comments;
    private Integer isPrivate;
    private Integer templateId;
    private String fields;
}
