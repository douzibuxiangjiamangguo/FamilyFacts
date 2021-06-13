package uk.ac.chen.middleware.entity.vo;

import lombok.Data;

/**
 * @author: Qiuyu
 */
@Data
public class PersonVO {

    private Integer personId;
    private String firstName;
    private String lastName;
    private String sex;
    private Integer birth;
    private Integer death;
    private String address;

    public PersonVO() {}

    public PersonVO(Integer personId, String firstName, String lastName, String sex,
                    Integer birth, Integer death, String address) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.birth = birth;
        this.death = death;
        this.address = address;
    }
}
