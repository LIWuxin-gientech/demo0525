package com.example.demo.service;

import com.example.demo.dto.UserSearchCondition;
import com.example.demo.entity.User;
import com.example.demo.Mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAppService {

    private final UserMapper userMapper;

    public UserAppService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public User findById(Long id) {
        return userMapper.findById(id);
    }

    public User create(User user) {
        userMapper.insert(user);
        return user;
    }

    public void update(User user) {
        userMapper.update(user);
    }

    public void deleteById(Long id) {
        userMapper.deleteById(id);
    }

    public List<User> search(UserSearchCondition condition) {
        return userMapper.searchByCondition(condition);
    }

    public List<User> findByIds(List<Long> ids) {
        return userMapper.findByIds(ids);
    }
}