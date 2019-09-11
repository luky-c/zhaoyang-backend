package com.zhaoyang.project.model.AdminUser;




public class AdminUserInfoBean {
	
	
	



    private String username;

    private String password;

    private String hashedPassword;
    

    
    


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
