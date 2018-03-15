package com.example.simplejsf.dao;

import com.example.simplejsf.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author pgutierrez
 */
public interface UserRoleDao extends JpaRepository<UserRole, Long> {

}
