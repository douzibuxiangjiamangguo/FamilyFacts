package uk.ac.chen.middleware.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Qiuyu
 * CREATE TABLE EventTable (EventID INTEGER PRIMARY KEY, EventType INTEGER, OwnerType INTEGER,
 * OwnerID INTEGER, FamilyID INTEGER, PlaceID INTEGER, SiteID INTEGER, Date TEXT, SortDate INTEGER,
 * IsPrimary INTEGER, IsPrivate INTEGER, Proof INTEGER, Status INTEGER, EditDate FLOAT);
 */
@Data
@TableName("EventTable")
public class EventEntity implements Serializable {

    private static final long serialVersionUID = -6509338789420928180L;

    private Integer eventId;
    private Integer eventType;
    private Integer ownerType;
    private Integer ownerId;
    private Integer familyId;
    private Integer placeId;
    private Integer siteId;
    private String date;
    private Integer sortDate;
    private Integer isPrimary;
    private Integer isPrivate;
    private Integer proof;
    private Integer status;
    private Float editDate;

}
