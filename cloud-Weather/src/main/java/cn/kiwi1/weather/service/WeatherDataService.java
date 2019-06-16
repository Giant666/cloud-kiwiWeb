package cn.kiwi1.weather.service;

import cn.kiwi1.weather.vo.Weather.WeatherResponse;

/**
 * @Auther:kiwi
 * @Date: 2019/6/14 14:07
 */
public interface WeatherDataService {

    WeatherResponse getDataByCityId(String cityId);

    WeatherResponse getDataByCityName(String cityName);

}
