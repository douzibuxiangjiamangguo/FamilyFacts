package uk.ac.chen.middleware.entity;

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

    private Integer addressId;
    private Integer addressType;
    private String name;
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String xip;
    private String country;
    private String phone1;
    private String phone2;
    private String fax;
    private String email;
    private String url;
    private Integer latitude;
    private Integer longitude;
    private String note;
}
