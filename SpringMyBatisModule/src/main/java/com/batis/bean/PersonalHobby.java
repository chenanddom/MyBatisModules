package com.batis.bean;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2018-08-31
 * Time: 12:31
 */
public class PersonalHobby implements Serializable {

private Long id;
private Long cityResidentId;
private String hobbyName;
private String hobbyCode;

    public PersonalHobby() {
    }

    public Long getId() {
        return id;
    }

    public Long getCityResidentId() {
        return cityResidentId;
    }

    public void setCityResidentId(Long cityResidentId) {
        this.cityResidentId = cityResidentId;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getHobbyName() {
        return hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }

    public String getHobbyCode() {
        return hobbyCode;
    }

    public void setHobbyCode(String hobbyCode) {
        this.hobbyCode = hobbyCode;
    }

    @Override
    public String toString() {
        return "PersonalHobby{" +
                "id=" + id +
                ", cityResidentId=" + cityResidentId +
                ", hobbyName='" + hobbyName + '\'' +
                ", hobbyCode='" + hobbyCode + '\'' +
                '}';
    }
}
