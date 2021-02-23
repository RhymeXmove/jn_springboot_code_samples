package org.javaboy.jdbctemplate.services;


import org.javaboy.jdbctemplate.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Controller
public class UserService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/adduser")
    @ResponseBody
    public int addUser(User user) {
        return jdbcTemplate.update("insert into user (username,address) values (?,?);",
                user.getUsername(), user.getAddress());
    }

    @GetMapping("/del")
    @ResponseBody
    public int delUserById(Long id) {
        String sql = "delete from user where id=?";
        return jdbcTemplate.update(sql, id);
    }

    @GetMapping("/upd")
    @ResponseBody
    public int updateUserById(User user) {
        String sql = "update user set username=?,address=? where id=?";
        return jdbcTemplate.update(sql, user.getUsername(), user.getAddress(), user.getId());
    }

    @GetMapping("/get")
    @ResponseBody
    public List<User> getAllUsers() {
        String sql = "select * from user";
        return jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                String username = resultSet.getString("username");
                String address = resultSet.getString("address");
                long id = resultSet.getLong("id");
                User user = new User();
                user.setAddress(address);
                user.setUsername(username);
                user.setId(id);
                return user;
            }
        });
    }
}
