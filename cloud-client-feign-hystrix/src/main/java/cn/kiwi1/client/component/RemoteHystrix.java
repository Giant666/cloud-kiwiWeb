package cn.kiwi1.client.component;
import cn.kiwi1.client.remote.CityClient;
import com.alibaba.fastjson.JSONObject;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Auther:kiwi
 * @Date: 2019/6/17 22:22
 */
@Component
public class RemoteHystrix implements FallbackFactory<CityClient> {


    @Override
    public CityClient create(Throwable throwable) {
        return new CityClient() {
            @Override
            public JSONObject listCity() {
                JSONObject json = new JSONObject();
                json.put("description", "服务不可用！");
                json.put("msg", null);
                return json;
            }
        };
    }
}
