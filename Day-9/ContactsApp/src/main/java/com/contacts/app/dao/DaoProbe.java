package com.contacts.app.dao;

import org.springframework.stereotype.Component;

//This is just for injecting the ContactDAO
@Component
public class DaoProbe {
    public DaoProbe(ContactDAO contactDAO){
        System.out.println("Injected"+contactDAO.getClass().getSimpleName());
    }
}
