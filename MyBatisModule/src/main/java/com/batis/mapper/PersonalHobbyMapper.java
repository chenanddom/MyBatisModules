package com.batis.mapper;

import com.batis.bean.PersonalHobby;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2018-08-31
 * Time: 12:33
 */
public interface PersonalHobbyMapper {
    List<PersonalHobby> getPersonHobbyId(@Param("cityResidentId")Long cityResidentId);
}
