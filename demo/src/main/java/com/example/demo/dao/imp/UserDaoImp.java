package com.example.demo.dao.imp;

import com.example.demo.dao.UserDao;
import com.example.demo.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public List<User> getALL() {
        return em.createQuery("from User", User.class).getResultList();
    }

    @Transactional
    @Override
    public User getUser(long id) {
        return em.find(User.class, id);
    }

    @Transactional
    @Override
    public User postUser(User user) {
        em.merge(user);
        return user;
    }

    @Transactional
    @Override
    public User putUser(long id, User user) {
        em.merge(user);
        return user;
    }

    @Transactional
    @Override
    public void deleteUser(long id) {
        User user = getUser(id);
        if (user != null) {
            em.remove(user);
        }
    }
    @Transactional
    @Override
    public User login(User user) {
        boolean authenticated = false;
        String hql = "FROM User u WHERE u.password IS NOT NULL AND u.email = :email";
        List<User> users = em.createQuery(hql.toString()).setParameter("email", user.getEmail()).getResultList();
        if(users.size()==0){
            return null;
        }
        User user1 = users.get(0);
        authenticated = true;
        if(!StringUtils.isEmpty(user.getPassword())){
            Argon2 argon2 =  Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
            authenticated = argon2.verify(user1.getPassword(), user.getPassword());
        }
        if(authenticated){
            return user1;
        }
        return null;
    }
}
