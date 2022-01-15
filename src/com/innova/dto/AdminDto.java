package com.innova.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//MVC
//Model
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder

public class AdminDto {
    private int adminId;
    private String adminName;
    private String adminSurname;
    private Date createdDate;


    public AdminDto() {
    }

    public AdminDto(int adminId, String adminName, String adminSurname, Date createdDate) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminSurname = adminSurname;
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "AdminDto{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", adminSurname='" + adminSurname + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminSurname() {
        return adminSurname;
    }

    public void setAdminSurname(String adminSurname) {
        this.adminSurname = adminSurname;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
