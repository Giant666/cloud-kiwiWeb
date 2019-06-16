package cn.kiwi1.weather.vo.Weather;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther:kiwi
 * @Date: 2019/6/14 10:58
 */
@Data
public class Yesterday implements Serializable {
    private static final long serialVersionUID = 1561825471965439491L;
    private String date;
    private String high;
    private String fx;
    private String low;
    private String fl;
    private String type;
}
