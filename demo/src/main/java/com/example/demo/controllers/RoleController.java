package com.example.demo.controllers;

import com.example.demo.models.Role;
import com.example.demo.services.RoleService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public List<Role> getRoles() {
        return roleService.getAllRoles();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Role getRole(@PathVariable long id){
        return roleService.getRoleById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Role addRole(@RequestBody Role role) {
        return roleService.postRole(role);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Role updateRole(@PathVariable long id, @RequestBody Role role) {
        return roleService.updateRole(id, role);
    }
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deleteRole(@PathVariable long id) {
        roleService.deleteRole(id);
    }
}
