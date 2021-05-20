package uk.ac.chen.middleware.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Qiuyu
 * CREATE TABLE ResearchItemTable (ItemID INTEGER PRIMARY KEY, LogID INTEGER, Date TEXT, SortDate INTEGER,
 * RefNumber TEXT, Repository TEXT, Goal TEXT, Source TEXT, Result TEXT);
 */
@Data
@TableName("ResearchItemTable")
public class ResearchItemEntity implements Serializable {

    private static final long serialVersionUID = -618543910385716561L;

    private Integer itemId;
    private Integer logId;
    private String date;
    private Integer sortDate;
    private String refNumber;
    private String repository;
    private String goal;
    private String source;
    private String result;
}
