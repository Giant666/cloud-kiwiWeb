package cn.kiwi1.weather.service.Impl;

import cn.kiwi1.weather.service.WeatherReportService;
import cn.kiwi1.weather.vo.Weather.Forecast;
import cn.kiwi1.weather.vo.Weather.Weather;
import cn.kiwi1.weather.vo.Weather.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther:kiwi
 * @Date: 2019/6/16 20:19
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {
    @Autowired
    private WeatherDataServiceImpl weatherDataService;

    @Override
    public Weather getDataByCityId(String cityId) {
        Weather data = new Weather();
        WeatherResponse weatherResponse = new WeatherResponse();
        List<Forecast> forecasts = new ArrayList<Forecast>();
        weatherResponse=weatherDataService.getDataByCityId("101280601");

        data = weatherResponse.getData();

        return data;

    }
}
