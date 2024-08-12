package com.example.demo.dao;

import com.example.demo.models.Role;

import java.util.List;

public interface RoleDao {

    List<Role> getALL();

    Role getRole(long id);

    Role postRole(Role role);

    Role putRole(long id, Role user);

    void deleteRole(long id);
}
