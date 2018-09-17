package com.batis.mapper;

import com.batis.bean.CityResident;
import com.batis.bean.CityResidentIdentificationCard;
import com.batis.bean.CityResidentIdentificationCardHobby;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2018-08-21
 * Time: 13:40
 */
@MapperScan
public interface CityResidentMapper {
//    @Select(" select * from test_demo1 where id = #{id}")
    CityResident selectCityResident(Integer id);

    List<CityResident> selectCityResidents();

    List<Map<String,Object>> selectCityResidentList();

    CityResidentIdentificationCard selectCityResidentById(@Param("id") Long id);

    CityResidentIdentificationCardHobby selectCityResidentsById(@Param("id") Long id);

    List<CityResident> selectPersonByNameId(@Param("id") Long id, @Param("userName") String userName);

    List<CityResident> selectPeronByConditions(@Param("cityResident") CityResident cityResident);

    CityResident findCityResidentsById(@Param("id") Long id);

    CityResident findCityResidentsUseTrim(@Param("id") Long id, @Param("userName") String userName);

    Integer updateCityResidentById(@Param("cityResident") CityResident cityResident);

    Integer updateCityResidentUseTrimSetById(@Param("cityResident") CityResident cityResident);

    List<CityResident> selectCityResidentUseForeachById(@Param("ids") List<Long> ids);

    List<CityResident> selectCityResidentUseBindByUserName(@Param("userName") String userName);

}
