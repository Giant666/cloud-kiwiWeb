package cn.kiwi1.weather.controller;

import cn.kiwi1.weather.service.Impl.WeatherDataServiceImpl;
import cn.kiwi1.weather.service.Impl.WeatherReportServiceImpl;
import cn.kiwi1.weather.vo.Weather.Forecast;
import cn.kiwi1.weather.vo.Weather.Weather;
import cn.kiwi1.weather.vo.Weather.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther:kiwi
 * @Date: 2019/6/15 17:31
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController {
    @Autowired
    private WeatherDataServiceImpl weatherService;

    @Autowired
    private WeatherReportServiceImpl weatherReportService;
    /**
     * 城市天气后台呈现
     * @param cityName
     * @param model
     * @return
     * @throws Exception
     */
    @GetMapping("/{cityName}")
    public ModelAndView weatherReportData(@PathVariable("cityName") String cityName, Model model)throws Exception{
        Weather data = new Weather();
        WeatherResponse weatherResponse = new WeatherResponse();
        List<Forecast> forecasts = new ArrayList<Forecast>();
        weatherResponse=weatherService.getDataByCityId("101280601");

        data = weatherResponse.getData();

        model.addAttribute("title", "天气预报");
        model.addAttribute("cityName", "ficl");
        model.addAttribute("cityList","ficl");
        model.addAttribute("report", weatherReportService.getDataByCityId("1"));
        return new ModelAndView("weather/report","reportData",model);
    }
}
