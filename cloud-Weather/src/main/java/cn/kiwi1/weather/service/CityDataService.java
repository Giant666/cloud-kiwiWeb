package cn.kiwi1.weather.service;

import cn.kiwi1.weather.vo.City.City;

import java.util.List;

/**
 * @Auther:kiwi
 * @Date: 2019/6/15 14:35
 */
public interface CityDataService {

    List<City> listCity() throws Exception;
}
