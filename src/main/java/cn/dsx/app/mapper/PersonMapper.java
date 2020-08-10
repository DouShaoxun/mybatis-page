package cn.dsx.app.mapper;

import cn.dsx.app.pojo.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author dousx
 * @version 1.0
 * @date 2020-08-10 20:20
 */
@Mapper
@Repository
public interface PersonMapper {

    List<Person> selectByPage(@Param("pageIndex") Long pageIndex,
                              @Param("pageNumber") Long pageNumber);
    List<Person> selectByPageHelper();

    int insert(Person person);
}
