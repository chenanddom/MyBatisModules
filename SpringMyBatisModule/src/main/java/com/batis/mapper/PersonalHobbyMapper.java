package com.batis.mapper;

import com.batis.bean.PersonalHobby;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2018-08-31
 * Time: 12:33
 */
@MapperScan
public interface PersonalHobbyMapper {
    List<PersonalHobby> getPersonHobbyId(@Param("cityResidentId") Long cityResidentId);
}
