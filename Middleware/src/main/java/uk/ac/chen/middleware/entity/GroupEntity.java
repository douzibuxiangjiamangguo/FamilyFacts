package uk.ac.chen.middleware.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Qiuyu
 * CREATE TABLE GroupTable (RecID INTEGER PRIMARY KEY, GroupID INTEGER, StartID INTEGER, EndID INTEGER);
 */
@Data
@TableName("GroupTable")
public class GroupEntity implements Serializable {

    private static final long serialVersionUID = 4875485084066282629L;

    private Integer recId;
    private Integer groupId;
    private Integer startId;
    private Integer endId;
}
