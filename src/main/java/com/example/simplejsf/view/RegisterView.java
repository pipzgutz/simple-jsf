package com.example.simplejsf.view;

import com.example.simplejsf.model.User;
import com.example.simplejsf.service.UserService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.print.attribute.standard.Severity;
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

    private User user;

    @Autowired
    private UserService userService;

    @PostConstruct
    public void init() {
        reset();
    }

    public List<User> getRegisteredUsers() {
        return userService.findAll();
    }

    public void save() {
        if (userService.findByName(user) != null) {
            FacesContext.getCurrentInstance().addMessage("Error", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "User with that name already exists"));
        } else {
            userService.save(user);
            reset();
        }
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
}
