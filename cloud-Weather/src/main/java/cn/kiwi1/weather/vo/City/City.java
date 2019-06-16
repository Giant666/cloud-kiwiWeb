package cn.kiwi1.weather.vo.City;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Auther:kiwi
 * @Date: 2019/6/15 14:25
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class City {
    private String cityId;
    private String cityName;
    private String cityCode;
    private String province;


}
