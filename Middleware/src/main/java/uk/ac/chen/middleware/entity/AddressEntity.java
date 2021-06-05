package uk.ac.chen.middleware.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Qiuyu
 * CREATE TABLE AddressTable (AddressID INTEGER PRIMARY KEY, AddressType INTEGER, Name TEXT,
 * Street1 TEXT, Street2 TEXT, City TEXT, State TEXT, Zip TEXT, Country TEXT, Phone1 TEXT,
 * Phone2 TEXT, Fax TEXT, Email TEXT, URL TEXT, Latitude INTEGER, Longitude INTEGER, Note BLOB );
 */
@Data
@TableName("AddressTable")
public class AddressEntity implements Serializable {

    private static final long serialVersionUID = 6074254070925565646L;

    @TableId(value = "AddressID", type = IdType.AUTO)
    private Integer addressId;

    @TableField("AddressType")
    private Integer addressType;

    @TableField("Name")
    private String name;

    @TableField("Street1")
    private String street1;

    @TableField("Street2")
    private String street2;

    @TableField("City")
    private String city;

    @TableField("State")
    private String state;

    @TableField("Zip")
    private String zip;

    @TableField("Country")
    private String country;

    @TableField("Phone1")
    private String phone1;

    @TableField("Phone2")
    private String phone2;

    @TableField("Fax")
    private String fax;

    @TableField("Email")
    private String email;

    @TableField("URL")
    private String url;

    @TableField("Latitude")
    private Integer latitude;

    @TableField("Longitude")
    private Integer longitude;

    @TableField("Note")
    private String note;

}
