package cn.kiwi1.weather.controller;

import cn.kiwi1.weather.service.CityClient;
import cn.kiwi1.weather.vo.City.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther:kiwi
 * @Date: 2019/6/17 10:22
 */
@RestController
public class CityController {

    @Autowired
    private CityClient cityClient;

    @GetMapping("/cities")
    public List<City> listCity() throws Exception {

        List<City> cities =null;
        cities = new ArrayList<>();
        City cityX = new City();
        cityX.setCityId("101280601");
        cities.add(cityX);

        List<City> body= cityClient.listCity();
        return body;


    }
}
