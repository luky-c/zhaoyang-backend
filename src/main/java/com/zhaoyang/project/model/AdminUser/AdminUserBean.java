package com.zhaoyang.project.model.AdminUser;

import java.util.List;

public class AdminUserBean {
    public AdminUserBean(){}
    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String status;

    private List<String> authorities;

    private Metadata metadata;
    private String sitewhereToken;

    public void setSitewhereToken(String sitewhereToken){
        this.sitewhereToken = sitewhereToken;
    }
    public String getSitewhereToken(){
        return this.sitewhereToken;
    }

    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return this.username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
    public void setAuthorities(List<String> authorities){
        this.authorities = authorities;
    }
    public List<String> getAuthorities(){
        return this.authorities;
    }
    public void setMetadata(Metadata metadata){
        this.metadata = metadata;
    }
    public Metadata getMetadata(){
        return this.metadata;
    }
}
