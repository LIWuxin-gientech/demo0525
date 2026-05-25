package com.example.demo.Mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    User findById(Long id);

    List<User> findAll();

    int insert(User user);

    int update(User user);

    int deleteById(Long id);

    List<User> searchUsers(
            @Param("name") String name,
            @Param("status") String status
    );

// Exercise: dynamic search using DTO
    List<User> searchByCondition(com.example.demo.dto.UserSearchCondition condition);

// Exercise: find by multiple ids
    List<User> findByIds(@Param("ids") java.util.List<Long> ids);
}