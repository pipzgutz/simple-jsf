package com.example.simplejsf.view;

import com.example.simplejsf.model.BankAccount;
import com.example.simplejsf.model.User;
import com.example.simplejsf.service.UserService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author pgutierrez
 */
@ViewScoped
@Component
public class AccountView implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private UserService userService;

    private List<User> users;

    private User selectedUser;

    private double money;

    @PostConstruct
    public void init() {
        users = userService.findAllUsers();
    }

    public void selectBalance(User user) {
        selectedUser = user;
    }

    public void withdraw() {
        BankAccount bankAccount = selectedUser.getBankAccounts().get(0);
        double existingBalance = bankAccount.getBalance();
        bankAccount.setBalance(existingBalance - money);

        userService.update(selectedUser);

        FacesContext.getCurrentInstance().addMessage("Success", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Success",
                "Withdraw of " + money + " was successful"));

        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("PF('withdrawDialog').hide()");
    }

    public void deposit() {
        BankAccount bankAccount = selectedUser.getBankAccounts().get(0);
        double existingBalance = bankAccount.getBalance();
        bankAccount.setBalance(existingBalance + money);

        userService.update(selectedUser);

        FacesContext.getCurrentInstance().addMessage("Success", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Success",
                "deposit of " + money + " was successful"));

        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("PF('depositDialog').hide()");
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
