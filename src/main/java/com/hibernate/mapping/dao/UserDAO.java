package com.hibernate.mapping.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.mapping.entity.User;

public class UserDAO {
private SessionFactory sessionFactory;
    
    public UserDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }
    
    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<User> users = session.createQuery("FROM User", User.class).getResultList();
        session.getTransaction().commit();
        return users;
    }
    
    public User getUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        session.getTransaction().commit();
        return user;
    }
    
    public void deleteUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
    }
}

