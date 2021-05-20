package uk.ac.chen.middleware.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Qiuyu
 * CREATE TABLE PlaceTable (PlaceID INTEGER PRIMARY KEY, PlaceType INTEGER, Name TEXT, Abbrev TEXT,
 * Normalized TEXT, Latitude INTEGER, Longitude INTEGER, LatLongExact INTEGER, MasterID INTEGER, Note BLOB );
 */
@Data
@TableName("PlaceTable")
public class PlaceEntity implements Serializable {

    private static final long serialVersionUID = 2990176546373992167L;

    private Integer placeId;
    private Integer placeType;
    private String name;
    private String abbrev;
    private Integer normalized;
    private Integer latitude;
    private Integer longitude;
    private Integer latLongExact;
    private Integer masterId;
    private String note;
}
