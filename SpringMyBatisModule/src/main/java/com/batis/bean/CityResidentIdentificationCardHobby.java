package com.batis.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2018-08-20
 * Time: 13:50
 */
public class CityResidentIdentificationCardHobby implements Serializable {
    private Long id;

    private String userName;

    private Integer userAge;

    private Integer sex;

    private IdentificationCard identificationCard;

    private List<PersonalHobby> personalHobbyList;

    public CityResidentIdentificationCardHobby(Long id, String userName, Integer userAge, Integer sex, IdentificationCard identificationCard) {
        this.id = id;
        this.userName = userName;
        this.userAge = userAge;
        this.sex = sex;
        this.identificationCard = identificationCard;
    }

    public CityResidentIdentificationCardHobby() {
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

    public List<PersonalHobby> getPersonalHobbyList() {
        return personalHobbyList;
    }

    public void setPersonalHobbyList(List<PersonalHobby> personalHobbyList) {
        this.personalHobbyList = personalHobbyList;
    }

    @Override
    public String toString() {
        return "CityResidentIdentificationCardHobby{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", sex=" + sex +
                ", identificationCard=" + identificationCard +
                ", personalHobbyList=" + personalHobbyList +
                '}';
    }
}
