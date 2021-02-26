package org.javaboy.mybatismulti.mapper2;

import org.javaboy.mybatismulti.bean.User;

import java.util.List;

/**
 * @Author 江南一点雨
 * @Site www.javaboy.org 2019-05-31 16:36
 */
//@Mapper
public interface UserMapper2{
//    @Select("select * from t_user")
    List<User> getAllUser();
}
