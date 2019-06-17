package cn.kiwi1.weather.service;

import cn.kiwi1.weather.vo.City.City;
import cn.kiwi1.weather.vo.Weather.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Auther:kiwi
 * @Date: 2019/6/17 19:48
 */
@FeignClient("kiwi-eureka-client-zuul")
public interface DataClient {

    @GetMapping("/cities")
    List<City> listCity() throws Exception;

    @GetMapping("/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId) throws Exception;
}
