package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.services.UserService;
import com.example.demo.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    JWTUtil jwtUtil;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<User> getALL(){
        return userService.getALL();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User getUser(@PathVariable long id){
        return userService.getUser(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    void postUser(@RequestBody User user){
         userService.postUser(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    User putUser(@PathVariable long id, @RequestBody User user){
       return userService.putUser(id, user);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void deleteUser(@PathVariable long id){
         userService.deleteUser(id);
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    Map<String, Object> login(@RequestBody User user){
        User userL = userService.login(user);

        Map<String, Object> result = new HashMap<>();
        if (userL != null) {
            String token = jwtUtil.create(String.valueOf(user.getId()), userL.getEmail());
            result.put("token", token);
            result.put("user", userL);
        }
        return result;
    }
}
