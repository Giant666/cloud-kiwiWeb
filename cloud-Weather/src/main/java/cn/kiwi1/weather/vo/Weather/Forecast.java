package cn.kiwi1.weather.vo.Weather;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther:kiwi
 * @Date: 2019/6/14 10:58
 */
@Data
public class Forecast implements Serializable {
    private static final long serialVersionUID = -8036856523823632187L;
    private String date;
    private String high;
    private String fengxiang;
    private String low;
    private String fengli;
    private String type;
}
