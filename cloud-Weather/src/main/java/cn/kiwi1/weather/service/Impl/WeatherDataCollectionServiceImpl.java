package cn.kiwi1.weather.service.Impl;

import cn.kiwi1.weather.service.RedisService;
import cn.kiwi1.weather.service.WeatherDataCollectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @Auther:kiwi
 * @Date: 2019/6/16 19:48
 */
@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {

    private final static Logger logger = LoggerFactory.getLogger(WeatherDataCollectionServiceImpl.class);

    @Autowired
    private RedisService redisService ;
    @Autowired
    private RestTemplate restTemplate;

    private final String WEAHER_API="http://wthrcdn.etouch.cn/weather_mini";

    private final Long TIME_OUT=1800L; //缓存超时时间



    @Override
    public void syncDataByCityId(String cityId) {
        logger.info("开始同步天气");
        String uri = WEAHER_API+"?citykey="+cityId;
        this.saveWeatherData(uri);
        logger.info("结束同步");
    }

    private void saveWeatherData(String uri){
        String key=uri;
        String strBody = null;

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

        if (responseEntity.getStatusCodeValue() == 200) {
            strBody = responseEntity.getBody();
        }
        redisService.set(key,strBody,TIME_OUT, TimeUnit.SECONDS);
    }


}
