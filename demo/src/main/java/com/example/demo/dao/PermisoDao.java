package com.example.demo.dao;

import com.example.demo.models.Permiso;

import java.util.List;

public interface PermisoDao {
    List<Permiso> getALL();

    Permiso getPermiso(long id);

    Permiso postPermiso(Permiso permiso);

    Permiso putPermiso(long id, Permiso permiso);

    void deletePermiso(long id);
}
