package com.example.simplejsf.service;

import com.example.simplejsf.dao.UserDao;
import com.example.simplejsf.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pgutierrez
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User findByName(User user) {
        return userDao.findByName(user.getFirstName(), user.getMiddleName(), user.getLastName());
    }
    
    public List<User> findAll() {
        return userDao.findAll();
    }

    public void save(User user) {
        userDao.save(user);
    }
}
