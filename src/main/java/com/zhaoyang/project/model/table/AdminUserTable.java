package com.zhaoyang.project.model.table;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AdminUserTable {
	
	
	
	@Id
	@GeneratedValue
    private long id;
	@Column(nullable = false)
    private String username;
	@Column(nullable = false)
    private String password;
	@Column(nullable = false)
    private String hashedPassword;
    
    public AdminUserTable(){}
    
    
    public AdminUserTable(String username,String password,String hashedPassword) {
        this.username = username;
        this.password = password;
        this.hashedPassword = hashedPassword;
    }
    
    public void setId(long id){
    	this.id = id;
    }
    public long getId()	{
    	return this.id;
    }

    public void setHashedPassword(String hashedPassword){
        this.hashedPassword = hashedPassword;
    }
    public String getHashedPassword(){
        return this.hashedPassword;
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
}