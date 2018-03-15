package com.example.simplejsf.view;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
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
    private ExternalContext externalContext;
    
    private static final long serialVersionUID = 1L;

    public String toUserAccountPage() {
        return externalContext.getRequestContextPath() + "/user/account.jsf";
    }
    
    public String toAdminRegisterPage() {
        return externalContext.getRequestContextPath() + "/admin/register.jsf";
    }
}
