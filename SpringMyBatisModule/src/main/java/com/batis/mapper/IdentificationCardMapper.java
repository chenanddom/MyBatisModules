package com.batis.mapper;

import com.batis.bean.IdentificationCard;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2018-08-31
 * Time: 8:25
 */
@MapperScan
public interface IdentificationCardMapper {
    IdentificationCard searchIdentificationByIdCard(@Param("id") Long id);

}
