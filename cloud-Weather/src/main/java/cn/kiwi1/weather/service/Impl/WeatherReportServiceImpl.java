package cn.kiwi1.weather.service.Impl;

import cn.kiwi1.weather.service.DataClient;
import cn.kiwi1.weather.service.WeatherReportService;
import cn.kiwi1.weather.vo.Weather.Weather;
import cn.kiwi1.weather.vo.Weather.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther:kiwi
 * @Date: 2019/6/16 20:19
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {
    @Autowired
    private DataClient dataClient;

    @Override
    public Weather getDataByCityId(String cityId) throws Exception {
        WeatherResponse weatherResponse;
        weatherResponse=dataClient.getDataByCityId("101280601");


        return weatherResponse.getData();

    }
}
