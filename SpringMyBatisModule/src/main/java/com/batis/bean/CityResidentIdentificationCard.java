package com.batis.bean;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2018-08-20
 * Time: 13:50
 */
public class CityResidentIdentificationCard implements Serializable {
    private Long id;

    private String userName;

    private Integer userAge;

    private Integer sex;

    private IdentificationCard identificationCard;

    public CityResidentIdentificationCard(Long id, String userName, Integer userAge, Integer sex, IdentificationCard identificationCard) {
        this.id = id;
        this.userName = userName;
        this.userAge = userAge;
        this.sex = sex;
        this.identificationCard = identificationCard;
    }

    public CityResidentIdentificationCard() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public IdentificationCard getIdentificationCard() {
        return identificationCard;
    }

    public void setIdentificationCard(IdentificationCard identificationCard) {
        this.identificationCard = identificationCard;
    }

    @Override
    public String toString() {
        return "CityResidentIdentificationCard{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", sex=" + sex +
                ", identificationCard=" + identificationCard +
                '}';
    }
}
