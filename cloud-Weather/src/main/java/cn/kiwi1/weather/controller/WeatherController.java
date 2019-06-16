package cn.kiwi1.weather.controller;

import cn.kiwi1.weather.service.Impl.WeatherDataServiceImpl;
import cn.kiwi1.weather.vo.Weather.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther:kiwi
 * @Date: 2019/6/14 14:38
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    private WeatherDataServiceImpl weatherDataService;

    @GetMapping("/cityId/{cityId}")
    public WeatherResponse getReportByCityId(@PathVariable("cityId")String cityId){
        return weatherDataService.getDataByCityId(cityId);
    }


    @PostMapping("/cityName/{cityName}")
    public WeatherResponse getReportByCityName(@PathVariable("cityName")String cityName){
        return weatherDataService.getDataByCityName(cityName);
    }
}
