package uk.ac.chen.middleware.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Qiuyu
 * CREATE TABLE SourceTemplateTable (TemplateID INTEGER PRIMARY KEY, Name TEXT, Description TEXT,
 * Favorite INTEGER, Category TEXT, Footnote TEXT, ShortFootnote TEXT, Bibliography TEXT, FieldDefs BLOB );
 */
@Data
@TableName("SourceTemplateTable")
public class SourceTemplateEntity implements Serializable {

    private static final long serialVersionUID = 3999660377409712150L;

    private Integer templateId;
    private String name;
    private String description;
    private Integer favorite;
    private String category;
    private String footnote;
    private String shortFootnote;
    private String bibliography;
    private String fieldDefs;
}
