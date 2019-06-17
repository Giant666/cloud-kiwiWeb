package cn.kiwi1.weather.service;

import cn.kiwi1.weather.vo.Weather.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Auther:kiwi
 * @Date: 2019/6/17 19:25
 */
@FeignClient("kiwi-eureka-data-client")
public interface WeatherDataClient {

    @GetMapping("/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);

}
