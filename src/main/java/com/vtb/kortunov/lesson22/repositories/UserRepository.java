package com.vtb.kortunov.lesson22.repositories;

import com.vtb.kortunov.lesson22.PrepareFactory;
import com.vtb.kortunov.lesson22.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepository {

    private final PrepareFactory factory;

    @Autowired
    public UserRepository(PrepareFactory factory) {
        this.factory = factory;
    }

    public void save(User user) {
        factory.getSession().beginTransaction();
        factory.getSession().save(user);
        factory.getSession().getTransaction().commit();
        factory.getSession().close();
    }

    public User get(Long id) {
        factory.getSession().beginTransaction();
        User user = factory.getSession().get(User.class, id);
        factory.getSession().getTransaction().commit();
        factory.getSession().close();
        return user;
    }

    public List<User> getAll() {
        factory.getSession().beginTransaction();
        List<User> users = factory.getSession().createQuery("SELECT u FROM User u", User.class).getResultList();
        factory.getSession().getTransaction().commit();
        factory.getSession().close();
        return users;
    }
}
