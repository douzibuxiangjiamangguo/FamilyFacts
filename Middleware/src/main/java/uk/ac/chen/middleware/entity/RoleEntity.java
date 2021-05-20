package uk.ac.chen.middleware.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Qiuyu
 * CREATE TABLE RoleTable (RoleID INTEGER PRIMARY KEY, RoleName TEXT, EventType INTEGER,
 * RoleType INTEGER, Sentence TEXT,
 */
@Data
@TableName("RoleTable")
public class RoleEntity implements Serializable {

    private static final long serialVersionUID = 2205604018456598569L;

    private Integer roleId;
    private String roleName;
    private Integer eventType;
    private Integer roleType;
    private String sentence;
}
