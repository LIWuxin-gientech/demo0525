package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/count")
    public String countUsers() {
        return "件数: " + userService.countUsers();
    }

    @DeleteMapping("/users/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        int rowsAffected = userService.deleteUser(id);
        if (rowsAffected > 0) {
            return "ユーザーが削除されました。ID: " + id;
        } else {
            return "ユーザーの削除に失敗しました。ID: " + id;

        }
    }

    @PutMapping("/users/update")
    public String updateUser(@RequestBody UpdateUserRequest request) {
        int rowsAffected = userService.updateUser(request.id(), request.name());
        if (rowsAffected > 0) {
            return "ユーザーが更新されました。ID: " + request.id() + ", 新しい名前: " + request.name();
        } else {
            return "ユーザーの更新に失敗しました。ID: " + request.id();
        }
    }

    @PostMapping("/users/insert")
    public String insertUser(@RequestBody InsertUserRequest request) {
        int rowsAffected = userService.insertUser(request.name(), request.age());
        if (rowsAffected > 0) {
            return "ユーザーが挿入されました。名前: " + request.name() + ", 年齢: " + request.age();
        } else {
            return "ユーザーの挿入に失敗しました。名前: " + request.name() + ", 年齢: " + request.age();
        }
    }

    @GetMapping("/users/names")
    public String findAllUserNames() {
        return "ユーザーの名前: " + userService.findAllUserNames();
    }

    @GetMapping("/users/name")
    public String findUserNameById(@RequestParam("id") Long id) {
        String name = userService.findUserNameById(id);
        if (name != null) {
            return "ユーザーの名前: " + name + " (ID: " + id + ")";
        } else {
            return "ユーザーが見つかりませんでした。ID: " + id;
        }
    }

    public record UpdateUserRequest(Long id, String name) {
    }

    public record InsertUserRequest(String name, Integer age) {
    }
}