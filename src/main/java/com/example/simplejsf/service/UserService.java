package com.example.simplejsf.service;

import com.example.simplejsf.dao.UserDao;
import com.example.simplejsf.model.User;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pgutierrez
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;

    public User findByName(User user) {
        return userDao.findByName(user.getFirstName(), user.getMiddleName(), user.getLastName());
    }
    
    public User findById(Long id) {
        return userDao.findOne(id);
    }
    
    public List<User> findAll() {
        return userDao.findAll();
    }
    
    public List<User> findAllUsers() {
        return userDao.findAllByRole("USER");
    }

    public void save(User user) {
        userDao.save(user);
    }
    
    public void delete(User user) {
        userDao.delete(user);
    }

    public void update(User selectedUser) {
        userDao.save(selectedUser);
    }
}
