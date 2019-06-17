package cn.kiwi1.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther:kiwi
 * @Date: 2019/6/17 10:22
 */
@RestController
public class test {

        @RequestMapping("hello/{name}")
        public String hello(@PathVariable String name) {
            return name + " say hello";
        }


}
