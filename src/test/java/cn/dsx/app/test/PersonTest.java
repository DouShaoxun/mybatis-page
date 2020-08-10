package cn.dsx.app.test;

import cn.dsx.app.mapper.PersonMapper;
import cn.dsx.app.pojo.Person;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author dousx
 * @version 1.0
 * @date 2020-08-10 20:25
 */
@SpringBootTest
public class PersonTest {

    @Autowired
    private PersonMapper personMapper;

    /**
     * 制造数据
     */
    @Test
    void insert() {
        // 雪花算法 生产主键id
        Snowflake snowflake = IdUtil.getSnowflake(1, 1);
        for (int i = 0; i < 30000; i++) {
            Person person = new Person();
            person.setId(snowflake.nextId() + "");
            person.setName(person.getId() + "Name");
            personMapper.insert(person);
        }
    }

    @Test
    void contextLoads() {
        List<Person> people = personMapper.selectByPage(1L, 1000L);
        System.out.println(people.size());
        people.forEach(System.out::println);
    }
    @Test
    void contextLoadssPageHelper() {
        //注意：sql中就不要写limit了，pageHelp会自己处理，sql就按不分页的那种写法就好
        //利用PageHelper分页查询 注意：这个一定要放查询语句的前一行,否则无法进行分页,因为它对紧随其后第一个sql语句有效
        Page page = PageHelper.startPage(1,10);
        List<Person> people = personMapper.selectByPageHelper();
        System.out.println(page.getTotal());
        System.out.println(page.getPageSize());
        System.out.println(page.size());
        page.getResult().forEach(System.out::println);
        System.out.println("=============");
        people.forEach(System.out::println);
    }
}
