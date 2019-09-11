package com.zhaoyang.project.model.EditTenantBean;

import java.util.List;

public class EditTenantBean {
    public EditTenantBean(){}
    private String id;

    private String name;

    private String logoUrl;

    private String authenticationToken;

    private List<String> authorizedUserIds;

    private String tenantTemplateId;

    private Metadata metadata;

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setLogoUrl(String logoUrl){
        this.logoUrl = logoUrl;
    }
    public String getLogoUrl(){
        return this.logoUrl;
    }
    public void setAuthenticationToken(String authenticationToken){
        this.authenticationToken = authenticationToken;
    }
    public String getAuthenticationToken(){
        return this.authenticationToken;
    }
    public void setAuthorizedUserIds(List<String> authorizedUserIds){
        this.authorizedUserIds = authorizedUserIds;
    }
    public List<String> getAuthorizedUserIds(){
        return this.authorizedUserIds;
    }
    public void setTenantTemplateId(String tenantTemplateId){
        this.tenantTemplateId = tenantTemplateId;
    }
    public String getTenantTemplateId(){
        return this.tenantTemplateId;
    }
    public void setMetadata(Metadata metadata){
        this.metadata = metadata;
    }
    public Metadata getMetadata(){
        return this.metadata;
    }
}
