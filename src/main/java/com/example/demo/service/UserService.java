package com.example.demo.service;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final JdbcTemplate jdbcTemplate;

    public UserService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Integer countUsers() {
        String sql = "select count(*) from users";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public String findUserNameById(Long id) {
        String sql = "select name from users where id = ?";
        return jdbcTemplate.queryForObject(sql, String.class, id);
    }

    public List<String> findAllUserNames() {
        String sql = "select name from users";
        return jdbcTemplate.query(sql,
                (rs, rowNum) -> rs.getString("name"));
    }

    public int insertUser(String name, Integer age) {
        String sql = "insert into users(name, age) values (?, ?)";
        return jdbcTemplate.update(sql, name, age);
    }

    public int updateUser(Long id, String name) {
        String sql = "update users set name = ? where id = ?";
        return jdbcTemplate.update(sql, name, id);
    }

    public int deleteUser(Long id) {
        String sql = "delete from users where id = ?";
        return jdbcTemplate.update(sql, id);
    }



}