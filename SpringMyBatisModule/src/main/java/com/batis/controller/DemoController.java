package com.batis.controller;

import com.batis.bean.CityResident;
import com.batis.mapper.CityResidentMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2018-09-12
 * Time: 9:25
 */
@Controller
@RequestMapping("/dmeo")
public class DemoController {

    @Resource
    CityResidentMapper cityResidentMapper;

    @RequestMapping("/getCityResident")
    @ResponseBody
    public CityResident getCityResident() {
        return cityResidentMapper.selectCityResident(1);
    }


}
