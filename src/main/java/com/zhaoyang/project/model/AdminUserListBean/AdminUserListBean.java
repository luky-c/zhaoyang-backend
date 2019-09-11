package com.zhaoyang.project.model.AdminUserListBean;

import java.util.List;

public class AdminUserListBean {
    private List<specToken> specToken;

    public AdminUserListBean(){}
    public void setSpecToken(List<specToken> specToken){
        this.specToken = specToken;
    }
    public List<specToken> getSpecToken(){
        return this.specToken;
    }
}
