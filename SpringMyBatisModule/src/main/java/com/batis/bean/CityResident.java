package com.batis.bean;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2018-08-20
 * Time: 13:50
 */
public class CityResident implements Serializable{
    private Long id;

    private String userName;

    private Integer userAge;

    private Integer sex;

    public CityResident(Long id, String userName, Integer userAge, Integer sex) {
        this.id = id;
        this.userName = userName;
        this.userAge = userAge;
        this.sex = sex;
    }

    public CityResident() {
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

    @Override
    public String toString() {
        return "CityResident{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", sex=" + sex +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CityResident that = (CityResident) o;

        if (!id.equals(that.id)) return false;
        if (!userName.equals(that.userName)) return false;
        if (!userAge.equals(that.userAge)) return false;
        return sex.equals(that.sex);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + userName.hashCode();
        result = 31 * result + userAge.hashCode();
        result = 31 * result + sex.hashCode();
        return result;
    }
}
