package cn.kiwi1.weather.service.Impl;

import cn.kiwi1.weather.service.RedisService;
import cn.kiwi1.weather.service.WeatherDataService;
import cn.kiwi1.weather.vo.Weather.WeatherResponse;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * @Auther:kiwi
 * @Date: 2019/6/14 14:09
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private final static Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);

    @Autowired
    private RedisService redisService ;
    @Autowired
    private RestTemplate restTemplate;

    private final String WEAHER_API="http://wthrcdn.etouch.cn/weather_mini";

    private final Long TIME_OUT=1800L; //缓存超时时间
    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEAHER_API+"?citykey="+cityId;
        return this.doGetWeatherData(uri);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEAHER_API+"?city="+cityName;
        return this.doGetWeatherData(uri);
    }


    private WeatherResponse doGetWeatherData(String uri){
        String key=uri;
        String strBody = null;

        if(!redisService.exists(key)) {
            logger.info("找不到key"+key);
            throw new RuntimeException("没有响应的天气信息");
        }else {
            logger.info("找到 key" + key+ ",value="+redisService.get(key));
            strBody= (String) redisService.get(key);
        }
        ObjectMapper mapper =new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);//JSON里面包含了没有相对应的实体导致反序列化失败。配置。

        WeatherResponse weather=null;
        try {
            weather =mapper.readValue(strBody,WeatherResponse.class);

        }catch (IOException e){
            logger.info("反序列化异常");
            throw  new RuntimeException("天气信息解析失败");
        }

        return weather;
    }

}
