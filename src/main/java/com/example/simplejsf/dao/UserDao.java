package com.example.simplejsf.dao;

import com.example.simplejsf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author pgutierrez
 */
public interface UserDao extends JpaRepository<User, Long> {
    User findByFirstNameAndMiddleNameAndLastName(String firstName, String middleName, String lastName);
}
