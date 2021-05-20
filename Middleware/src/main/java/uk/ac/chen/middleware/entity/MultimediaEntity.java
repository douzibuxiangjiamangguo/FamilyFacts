package uk.ac.chen.middleware.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Qiuyu
 *
 * CREATE TABLE MultimediaTable (MediaID INTEGER PRIMARY KEY, MediaType INTEGER,
 * MediaPath TEXT, MediaFile TEXT, URL TEXT, Thumbnail BLOB, Caption TEXT,
 * RefNumber TEXT, Date TEXT, SortDate INTEGER, Description BLOB );
 */
@Data
@TableName("MultimediaTable")
public class MultimediaEntity implements Serializable {

    private static final long serialVersionUID = 1187896375188615763L;

    private int mediaId;
    private int mediaType;
    private String mediaPath;
    private String mediaFile;
    private String url;
    private String thumbnail;
    private String caption;
    private String refNumber;
    private String Date;
    private int sortDate;
    private String description;
}
