package uk.ac.chen.middleware.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Qiuyu
 * CREATE TABLE AddressLinkTable (LinkID INTEGER PRIMARY KEY, OwnerType INTEGER,
 * AddressID INTEGER, OwnerID INTEGER, AddressNum INTEGER, Details TEXT,
 */
@Data
@TableName("AddressLinkTable")
public class AddressLinkEntity implements Serializable {

    private static final long serialVersionUID = -7366805771726984615L;

    private Integer linkId;
    private Integer ownerType;
    private Integer addressId;
    private Integer ownerId;
    private Integer addressNum;
    private String details;
}
