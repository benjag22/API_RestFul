package com.example.demo.dao;

import com.example.demo.models.User;
import java.util.List;

public interface UserDao {
    List<User> getALL();

    User getUser(long id);

    User postUser(User user);

    User putUser(long id, User user);

    void deleteUser(long id);
    User login(User user);
}
