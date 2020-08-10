package cn.dsx.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author dousx
 * @version 1.0
 * @date 2020-08-10 20:13
 */
@SpringBootApplication
@MapperScan(value = {"cn.dsx.app.mapper"})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
