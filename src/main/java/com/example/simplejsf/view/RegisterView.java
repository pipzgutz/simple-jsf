package com.example.simplejsf.view;

import com.example.simplejsf.model.BankAccount;
import com.example.simplejsf.model.User;
import com.example.simplejsf.model.UserRole;
import com.example.simplejsf.service.UserService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author pgutierrez
 */
@RequestScoped
@Component
public class RegisterView implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private FacesContext facesContext;
    
    @Autowired
    private UserService userService;
    
    private User user;
    
    private String role;
    
    @PostConstruct
    public void init() {
        
        reset();
    }

    public List<User> getRegisteredUsers() {
        return userService.findAll();
    }

    public void save() {
        if (userService.findByName(user) != null) {
            facesContext.addMessage("Error", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "User with that name already exists"));
        } else {
            List<UserRole> userRoles = new ArrayList<>();
            UserRole userRole = new UserRole(role);
            userRoles.add(userRole);
            user.setUserRoles(userRoles);
            
            if ("USER".equals(userRole.getRole())) {
                List<BankAccount> bankAccounts = new ArrayList<>();
                bankAccounts.add(new BankAccount(3000.0));
                user.setBankAccounts(bankAccounts);
            }
            
            userService.save(user);
            facesContext.addMessage("Success", new FacesMessage("Success", "User successfully created"));

            RequestContext requestContext = RequestContext.getCurrentInstance();
            requestContext.execute("PF('registerDialog').hide()");
            
            reset();
        }
    }
    
    public void delete(User userToDelete) {
        userService.delete(userToDelete);
        
        facesContext.addMessage("Success", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Success", "Successfully delete user"));
        
        reset();
    }
    
    private void reset() {
        user = new User();
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
