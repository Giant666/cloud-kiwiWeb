package cn.kiwi1.weather.job;

import cn.kiwi1.weather.service.CityClient;
import cn.kiwi1.weather.service.Impl.WeatherDataCollectionServiceImpl;
import cn.kiwi1.weather.vo.City.City;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther:kiwi
 * 同步天气数据的定时任务
 * @Date: 2019/6/15 14:04
 */
@Component(value = "weatherDataSyncJob")
public class WeatherDataSyncJob extends QuartzJobBean {
    private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);

    @Autowired
    private WeatherDataCollectionServiceImpl weatherDataCollectionService;
    @Autowired
    private CityClient cityClient;

    @Override
    protected void executeInternal(org.quartz.JobExecutionContext context) throws JobExecutionException {
        logger.info("天气数据同步任务");

        List<City> cities =null;
        try {

//
//
//            cities = new ArrayList<>();
//            City cityX = new City();
//            cityX.setCityId("101280601");
//            cities.add(cityX);
//
//            for(City city:cities){
//                String cityId=city.getCityId();
//                logger.info("天气数据同步任务中，id：",cityId);
//
//                weatherDataCollectionService.syncDataByCityId(cityId);
//
//            }
//            logger.info("天气数据同步任务完成！");
//
            cities=cityClient.listCity();

            for(City city:cities){
                String cityId=city.getCityId();
                logger.info("天气数据同步任务中，id：",cityId);

                weatherDataCollectionService.syncDataByCityId(cityId);

            }
            logger.info("天气数据同步任务完成！");
        }catch (Exception e){
            logger.info("获取城市异常");
        }



    }
}
