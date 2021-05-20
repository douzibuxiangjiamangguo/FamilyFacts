package uk.ac.chen.middleware.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Qiuyu
 * CREATE TABLE URLTable (LinkID INTEGER PRIMARY KEY, OwnerType INTEGER, OwnerID INTEGER,
 * LinkType INTEGER, Name TEXT, URL TEXT, Note BLOB);
 */
@Data
@TableName("URLTable")
public class UrlEntity implements Serializable {

    private static final long serialVersionUID = 1442195785308934348L;

    private Integer linkId;
    private Integer ownerType;
    private Integer ownerId;
    private Integer linkType;
    private String name;
    private String url;
    private String note;
}
