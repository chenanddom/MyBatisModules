package com.batis.bean;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2018-08-30
 * Time: 9:41
 */
public class IdentificationCard implements Serializable {

    private Long id;

    private String identificationNumber;

    private Integer effectiveDate;

    private Timestamp startDate;


    public IdentificationCard() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public Integer getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Integer effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "IdentificationCard{" +
                "id=" + id +
                ", identificationNumber='" + identificationNumber + '\'' +
                ", effectiveDate=" + effectiveDate +
                ", startDate=" + startDate +
                '}';
    }
}
