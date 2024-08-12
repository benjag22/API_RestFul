package com.example.demo.services;

import com.example.demo.dao.RoleDao;
import com.example.demo.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleDao roleDao;

    public List<Role> getAllRoles() {
        return roleDao.getALL();
    }
    public Role getRoleById(long id) {
        return roleDao.getRole(id);
    }
    public Role postRole(Role role) {
        return roleDao.postRole(role);
    }
    public Role updateRole(long id, Role role) {
        return roleDao.putRole(id, role);
    }
    public void deleteRole(long id) {
        roleDao.deleteRole(id);
    }

}
