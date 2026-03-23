package com.example.mysql_demo.service;

import com.example.mysql_demo.dao.AdminDAO;

public class AdminService {

    AdminDAO dao = new AdminDAO();

    public void addSpecialty(String name,String desc) throws Exception {

        dao.addSpecialty(name,desc);
    }

    public void viewSpecialties() throws Exception {

        dao.viewSpecialties();
    }

    public void deleteSpecialty(int id) throws Exception {

        dao.deleteSpecialty(id);
    }

    public void viewAuditLogs() throws Exception {

        dao.viewAuditLogs();
    }
}
