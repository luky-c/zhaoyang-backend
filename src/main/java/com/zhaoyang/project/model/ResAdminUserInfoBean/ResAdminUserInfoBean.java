package com.zhaoyang.project.model.ResAdminUserInfoBean;

import java.util.List;

//新建后返回的admin user信息
public class ResAdminUserInfoBean {
    public ResAdminUserInfoBean(){}
    private String createdDate;

    private String createdBy;

    private boolean deleted;

    private String username;

    private String hashedPassword;

    private String firstName;

    private String lastName;

    private String status;

    private List<String> authorities;

    private Metadata metadata;

    public void setCreatedDate(String createdDate){
        this.createdDate = createdDate;
    }
    public String getCreatedDate(){
        return this.createdDate;
    }
    public void setCreatedBy(String createdBy){
        this.createdBy = createdBy;
    }
    public String getCreatedBy(){
        return this.createdBy;
    }
    public void setDeleted(boolean deleted){
        this.deleted = deleted;
    }
    public boolean getDeleted(){
        return this.deleted;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return this.username;
    }
    public void setHashedPassword(String hashedPassword){
        this.hashedPassword = hashedPassword;
    }
    public String getHashedPassword(){
        return this.hashedPassword;
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
