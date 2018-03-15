package com.example.simplejsf.service;

import com.example.simplejsf.dao.UserRoleDao;
import com.example.simplejsf.model.UserRole;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pgutierrez
 */
@Service
public class UserRoleService {
    @Autowired
    private UserRoleDao userRoleDao;
    
    public List<UserRole> findAll() {
        return userRoleDao.findAll();
    }
}
