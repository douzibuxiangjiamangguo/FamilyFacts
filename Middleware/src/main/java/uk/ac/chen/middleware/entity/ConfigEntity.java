package uk.ac.chen.middleware.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Qiuyu
 *
 * CREATE TABLE ConfigTable (RecID INTEGER PRIMARY KEY, RecType INTEGER, Title TEXT, DataRec BLOB );
 */
@Data
@TableName("ConfigTable")
public class ConfigEntity implements Serializable {

    private static final long serialVersionUID = -2687362520800596104L;

    private Integer recId;
    private Integer recType;
    private String title;
    private String dataRec;
}
