package com.example.simplejsf.dao;

import com.example.simplejsf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author pgutierrez
 */
public interface UserDao extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.firstName = ? AND u.middleName = ? AND u.lastName = ?")
    User findByName(String firstName, String middleName, String lastName);
}
