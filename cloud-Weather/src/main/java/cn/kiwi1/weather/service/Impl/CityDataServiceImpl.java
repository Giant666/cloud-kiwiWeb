package cn.kiwi1.weather.service.Impl;

import cn.kiwi1.weather.service.CityDataService;
import cn.kiwi1.weather.vo.City.City;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther:kiwi
 * @Date: 2019/6/16 20:56
 */
@Service
public class CityDataServiceImpl implements CityDataService {

    @Override
    public List<City> listCity() throws Exception {
        List<City> cities =null;
        cities = new ArrayList<>();
        City cityX = new City();
        cityX.setCityId("101280601");
        cities.add(cityX);

        return cities;
    }
}
