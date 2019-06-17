package cn.kiwi1.client.controller;

import cn.kiwi1.client.remote.CityClient;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther:kiwi
 * @Date: 2019/6/17 10:22
 */
@RestController
public class CityController {

    @Autowired
    private CityClient cityClient;

    @GetMapping(name="/cities")
    public JSONObject listCity() {
         return  cityClient.listCity();

    }

    public String defaultCities() {
        return "城市数据API服务暂时不可用！";

    }
}
