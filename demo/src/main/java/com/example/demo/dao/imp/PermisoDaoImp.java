package com.example.demo.dao.imp;

import com.example.demo.dao.PermisoDao;
import com.example.demo.models.Permiso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PermisoDaoImp implements PermisoDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Permiso> getALL(){
        return em.createQuery("from Permiso", Permiso.class).getResultList();
    }
    @Override
    public Permiso getPermiso(long id){
        return em.find(Permiso.class, id);
    }

    @Override
    public Permiso postPermiso(Permiso permiso){
        em.merge(permiso);
        return permiso;
    }

    @Override
    public Permiso putPermiso(long id, Permiso permiso){
        em.merge(permiso);
        return permiso;
    }

    @Override
    public void deletePermiso(long id){
        Permiso permiso = getPermiso(id);
        if(permiso != null){
            em.remove(permiso);
        }
    }
}
