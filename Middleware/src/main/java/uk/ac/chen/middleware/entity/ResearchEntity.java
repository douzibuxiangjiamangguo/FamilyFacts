package uk.ac.chen.middleware.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Qiuyu
 * CREATE TABLE ResearchTable (TaskID INTEGER PRIMARY KEY, TaskType INTEGER, OwnerID INTEGER,
 * OwnerType INTEGER, RefNumber TEXT, Name TEXT, Status INTEGER, Priority INTEGER, Date1 TEXT,
 * Date2 TEXT, Date3 TEXT, SortDate1 INTEGER, SortDate2 INTEGER, SortDate3 INTEGER, Filename TEXT,
 * Details BLOB);
 */
@Data
@TableName("ResearchTable")
public class ResearchEntity implements Serializable {

    private static final long serialVersionUID = 4893853536777151872L;

    private Integer taskId;
    private Integer taskType;
    private Integer ownerId;
    private Integer ownerType;
    private String refNumber;
    private String name;
    private Integer status;
    private Integer priority;
    private String date1;
    private String date2;
    private String date3;
    private Integer sortDate1;
    private Integer sortDate2;
    private Integer sortDate3;
    private String filename;
    private String details;
}
