package com.example.simplejsf.view;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.springframework.stereotype.Component;

/**
 *
 * @author pgutierrez
 */
@RequestScoped
@Component
public class NavigationView implements Serializable {

    @Inject
    private FacesContext facesContext;
    
    private static final long serialVersionUID = 1L;

    public String toUserAccountPage() {
        return facesContext.getExternalContext().getRequestContextPath() + "/user/account.jsf";
    }
    
    public String toAdminRegisterPage() {
        return facesContext.getExternalContext().getRequestContextPath() + "/admin/register.jsf";
    }
}
