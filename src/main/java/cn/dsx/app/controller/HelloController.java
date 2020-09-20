package cn.dsx.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Dsx
 * @Date: 2020/09/20/13:15
 * @Description:
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/1")
    public String getOne() {
        return "1";
    }

}