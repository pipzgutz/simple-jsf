package com.example.simplejsf.converter;

import com.example.simplejsf.model.User;
import com.example.simplejsf.service.UserService;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pgutierrez
 */
@Service
public class UserConverter implements Converter {

    @Autowired
    private UserService userService;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String submittedValue) {
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }

        try {
            return userService.findById(Long.valueOf(submittedValue));
        } catch (RuntimeException ex) {
            throw new RuntimeException(submittedValue + " is not a valid user (object)");
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null) {
            return "";
        }
        
        return o.toString();
    }

}
