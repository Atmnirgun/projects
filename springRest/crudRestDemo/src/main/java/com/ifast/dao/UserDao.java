package com.ifast.dao;

import com.ifast.entities.User;

import java.util.List;

public interface UserDao {
    public User getById(int id);
    public User save(User user);
    public List<User> getAll();
    public Boolean delete(int id);
}
