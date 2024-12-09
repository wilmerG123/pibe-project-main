package com.project.models.dtos;

import java.util.List;


public class CoachDTO {
    private String userName;
    private String name;
    private String lastName;
    private String mail;
    private String password;
    private String phone;
    private List<CategoryDTO> categories;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }


    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }
}
