package com.example.demo.controllers;

import com.example.demo.models.Permiso;
import com.example.demo.services.PermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("permiso")

public class PermisoController {
    @Autowired
    PermisoService permisoService;

    @RequestMapping(value="/",method = RequestMethod.GET)
    public List<Permiso> getPermisos() {
        return permisoService.getAll();
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Permiso getPermiso(@PathVariable long id) {
        return permisoService.getById(id);
    }
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Permiso postPermiso(@RequestBody Permiso permiso) {
        return permisoService.postPermiso(permiso);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Permiso putPermiso(@PathVariable long id, @RequestBody Permiso permiso) {
        return permisoService.updatePermiso(id, permiso);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePermiso(@PathVariable long id) {
        permisoService.deletePermiso(id);
    }
}
