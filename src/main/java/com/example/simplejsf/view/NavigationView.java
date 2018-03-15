package com.example.simplejsf.view;

import java.io.Serializable;
import javax.faces.context.FacesContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author pgutierrez
 */
@Component
public class NavigationView implements Serializable {

    private static final long serialVersionUID = 1L;

    public String toUserAccountPage() {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "/user/account.jsf";
    }
    
    public String toAdminRegisterPage() {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "/admin/register.jsf";
    }
}
