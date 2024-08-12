package com.example.demo.services;

import com.example.demo.dao.UserDao;
import com.example.demo.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getALL(){
        return userDao.getALL();
    }

    public User getUser(long id){
        return userDao.getUser(id);
    }

    public void postUser(User user){
        String password = user.getPassword();
        String hashPassword = generarHash(password);
        user.setPassword(hashPassword);
        userDao.postUser(user);
    }

    public User putUser(long id, User user){
        return userDao.putUser(id, user);
    }

    public void deleteUser(long id){
        userDao.deleteUser(id);
    }
    private String generarHash(String password){
        Argon2 argon2 =  Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        return argon2.hash(1,2024*1,1,password);
    }
    public User login(User user){
        return userDao.login(user);
    }
}
