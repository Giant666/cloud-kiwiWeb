package cn.kiwi1.config.client.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther:kiwi
 * @Date: 2019/6/18 20:29
 */
@RestController
@RefreshScope
public class TestController {
    @Value("${auther}")
    private String auther;

    @Value("${version}")
    private String version;

    @RequestMapping("/config")
    public String from() {
        return auther+" "+version;
    }
}
