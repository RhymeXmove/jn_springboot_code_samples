package org.javaboy.mybatismulti.mapper1;



import org.javaboy.mybatismulti.bean.User;

import java.util.List;


//@Mapper
public interface UserMapper1 {
//    @Select("select * from t_user")
    List<User> getAllUser();
}
