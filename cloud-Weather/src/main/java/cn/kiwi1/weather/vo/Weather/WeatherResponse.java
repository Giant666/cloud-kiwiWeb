package cn.kiwi1.weather.vo.Weather;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther:kiwi
 * @Date: 2019/6/14 10:59
 */
@Data
public class WeatherResponse implements Serializable {

    private static final long serialVersionUID = 1576892483328358364L;
    private Weather data;
    private String status;
    private String desc;
}
