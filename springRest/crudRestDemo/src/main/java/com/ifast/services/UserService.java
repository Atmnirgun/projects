package com.ifast.services;

import com.ifast.entities.User;

import java.util.List;

public interface UserService {
    public User getUser(int id);
    public User createUser(User user);
    public List<User> getAllUser();
    public Boolean deleteUser(int id);
}
