package com.example.demo.dao.imp;

import com.example.demo.dao.RoleDao;
import com.example.demo.models.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class RoleDaoImp implements RoleDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Role> getALL() {
        return em.createQuery("from Role", Role.class).getResultList();
    }

    @Override
    public Role getRole(long id) {
        return em.find(Role.class, id);
    }

    @Override
    public Role postRole(Role role) {
        em.merge(role);
        return role;
    }

    @Override
    public Role putRole(long id, Role role) {
        em.merge(role);
        return role;
    }

    @Override
    public void deleteRole(long id){
        Role role = getRole(id);
        if(role != null){
            em.remove(role);
        }
    }
}
