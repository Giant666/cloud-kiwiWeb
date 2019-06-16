package cn.kiwi1.weather.vo.Weather;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther:kiwi
 * @Date: 2019/6/14 10:45
 */
@Data
public class Weather implements Serializable {
    private static final long serialVersionUID = 8558989350454145548L;
    private String city;
    private String aqi;
    private String wendu;
    private String ganmao;
    private Yesterday yesterday;
    private List<Forecast> forecast;
}
