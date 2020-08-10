package cn.dsx.app.test;

import cn.dsx.app.mapper.PersonMapper;
import cn.dsx.app.pojo.Person;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.apache.ibatis.session.RowBounds;
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
    void contextLoadsRowBounds() {
        List<Person> people = personMapper.selectByRowBounds(new RowBounds(0, 30));
        System.out.println(people.size());
        people.forEach(System.out::println);
    }
}
