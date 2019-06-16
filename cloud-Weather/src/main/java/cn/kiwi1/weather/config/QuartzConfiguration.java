package cn.kiwi1.weather.config;

import cn.kiwi1.weather.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther:kiwi
 * @Date: 2019/6/15 14:16
 */
@Configuration
public class QuartzConfiguration {

    private final int TIME = 1800;//更新频率
    /**
     *@Auther kiwi
     *@Data 2019/6/15
     * 定义特点的job
     @param  * @param
     *@reutn org.quartz.JobDetail
    */
    @Bean
    public JobDetail weatherDataSyncJobJobDetail(){
        return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataSyncJob").storeDurably().build();
    }


    /**
     *@Auther kiwi
     *@Data 2019/6/15
     * 定义了每2秒来触发特定的Job
     @param  * @param
     *@reutn org.quartz.Trigger
    */
    @Bean
    public Trigger sampleJobTrigger(){
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(TIME).repeatForever();
        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobJobDetail())
                .withIdentity("weatherDataSyncTrigger").withSchedule(simpleScheduleBuilder).build();
    }
}
