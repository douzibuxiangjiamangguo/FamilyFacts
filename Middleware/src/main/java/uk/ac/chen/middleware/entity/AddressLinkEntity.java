package uk.ac.chen.middleware.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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

    @TableId(value = "LinkID", type = IdType.AUTO)
    private Integer linkId;

    @TableField("OwnerType")
    private Integer ownerType;

    @TableField("AddressID")
    private Integer addressId;

    @TableField("OwnerID")
    private Integer ownerId;

    @TableField("AddressNum")
    private Integer addressNum;

    @TableField("Details")
    private String details;
}
