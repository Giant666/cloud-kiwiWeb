package cn.kiwi1.client.remote;

import cn.kiwi1.client.component.RemoteHystrix;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Auther:kiwi
 * @Date: 2019/6/17 17:19
 */
@FeignClient(name="kiwi-eureka-city-client",fallbackFactory= RemoteHystrix.class)
public interface CityClient {

    @GetMapping("/cities")
    JSONObject listCity();
}
