package cn.kiwi1.weather.service;

import cn.kiwi1.weather.vo.Weather.Weather;

/**
 * @Auther:kiwi
 * @Date: 2019/6/16 20:16
 */
public interface WeatherReportService {

    /**
     *@Auther kiwi
     * 根据城市Id查询信息
     *@Data 2019/6/16
     @param  * @param cityId
     *@reutn Weather
    */
    Weather getDataByCityId(String cityId);
}
