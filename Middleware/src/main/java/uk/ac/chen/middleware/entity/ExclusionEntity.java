package uk.ac.chen.middleware.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Qiuyu
 * CREATE TABLE ExclusionTable (RecID INTEGER PRIMARY KEY, ExclusionType INTEGER, ID1 INTEGER, ID2 INTEGER );
 */
@Data
@TableName("ExclusionTable")
public class ExclusionEntity implements Serializable {

    private static final long serialVersionUID = -5647821468870567291L;

    private Integer recId;
    private Integer exclusionType;
    private Integer id1;
    private Integer id2;
}
