package uk.ac.chen.middleware.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Qiuyu
 * CREATE TABLE LabelTable (LabelID INTEGER PRIMARY KEY, LabelType INTEGER, LabelValue INTEGER,
 * LabelName TEXT, Description TEXT );
 */
@Data
@TableName("LabelTable")
public class LabelEntity implements Serializable {

    private static final long serialVersionUID = -7548579390067415540L;

    private Integer labelId;
    private Integer labelType;
    private Integer labelValue;
    private String labelName;
    private String description;
}
