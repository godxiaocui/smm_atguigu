package com.czh.mybatis.mapper;

import com.czh.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

// 可以用#{}和${} 表示
/// #{}本质是占位符 ？，防止sql注入
// ${}  需要加单引号‘${}’
public interface UserMapper {
    User getUserByUsername(String username);
    User CheckLogin(String username, String password);
    void insertUser(User user);

    User CheckLoginParam(@Param("czh") String username,@Param("ylt")  String password);
//   添加数据后获取自动的主键中，非常重要
    void insertUserAndKey(User user);
}
