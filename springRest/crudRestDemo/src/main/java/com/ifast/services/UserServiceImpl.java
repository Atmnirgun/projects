package com.ifast.services;

import com.ifast.dao.UserDao;
import com.ifast.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(int id) {
        return userDao.getById(id);
    }

    @Override
    public User createUser(User user) {
        return userDao.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAll();
    }

    @Override
    public Boolean deleteUser(int id) {
        return userDao.delete(id);
    }
}
