package uk.ac.chen.middleware.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Qiuyu
 * CREATE TABLE WitnessTable (WitnessID INTEGER PRIMARY KEY, EventID INTEGER, PersonID INTEGER,
 * WitnessOrder INTEGER, Role INTEGER, Sentence TEXT, Note BLOB, Given TEXT, Surname TEXT,
 * Prefix TEXT, Suffix TEXT);
 */
@Data
@TableName("WitnessTable")
public class WitnessEntity implements Serializable {

    private static final long serialVersionUID = -2529779845454753329L;

    private Integer witnessId;
    private Integer eventId;
    private Integer personId;
    private Integer witnessOrder;
    private Integer role;
    private String sentence;
    private String note;
    private String given;
    private String surname;
    private String prefix;
    private String suffix;
}
