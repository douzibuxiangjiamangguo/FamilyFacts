package uk.ac.chen.middleware.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Qiuyu
 * CREATE TABLE MediaLinkTable (LinkID INTEGER PRIMARY KEY, MediaID INTEGER, OwnerType INTEGER,
 * OwnerID INTEGER, IsPrimary INTEGER, Include1 INTEGER, Include2 INTEGER, Include3 INTEGER,
 * Include4 INTEGER, SortOrder INTEGER, RectLeft INTEGER, RectTop INTEGER, RectRight INTEGER,
 * RectBottom INTEGER, Note TEXT, Caption TEXT, RefNumber TEXT, Date TEXT, SortDate INTEGER,
 * Description BLOB);
 */
@Data
@TableName("MediaLinkTable")
public class MediaLinkEntity implements Serializable {

    private static final long serialVersionUID = -2386320406706424911L;

    private Integer linkId;
    private Integer mediaId;
    private Integer ownerType;
    private Integer ownerId;
    private Integer isPrimary;
    private Integer include1;
    private Integer include2;
    private Integer include3;
    private Integer include4;
    private Integer sortOrder;
    private Integer rectLeft;
    private Integer rectTop;
    private Integer rectRight;
    private Integer rectBottom;
    private String  note;
    private String  caption;
    private String  refNumber;
    private String  date;
    private Integer sortDate;
    private String  description;
}
