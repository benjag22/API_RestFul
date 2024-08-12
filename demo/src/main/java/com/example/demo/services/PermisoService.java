package com.example.demo.services;

import com.example.demo.dao.PermisoDao;
import com.example.demo.models.Permiso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermisoService {
    @Autowired
    PermisoDao permisoDao;
    public List<Permiso> getAll() {
        return permisoDao.getALL();
    }
    public Permiso getById(long id) {
        return permisoDao.getPermiso(id);
    }
    public Permiso postPermiso(Permiso permiso) {
        return permisoDao.postPermiso(permiso);
    }
    public Permiso updatePermiso(long id, Permiso permiso) {
        return permisoDao.putPermiso(id,permiso);
    }
    public void deletePermiso(long id) {
        permisoDao.deletePermiso(id);
    }
}
