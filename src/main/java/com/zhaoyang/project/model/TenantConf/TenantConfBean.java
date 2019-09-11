package com.zhaoyang.project.model.TenantConf;

import com.zhaoyang.project.model.TenantConf.Children.Children;

import java.util.List;

public class TenantConfBean {
    public TenantConfBean(){}
    private String name;

    private String namespace;

    private String id;

    public String getSitewhereToken() {
        return sitewhereToken;
    }

    public void setSitewhereToken(String sitewhereToken) {
        this.sitewhereToken = sitewhereToken;
    }

    private String sitewhereToken;

    private List<Children> children ;

    private List<Attributes> attributes ;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setNamespace(String namespace){
        this.namespace = namespace;
    }
    public String getNamespace(){
        return this.namespace;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setChildren(List<Children> children){
        this.children = children;
    }
    public List<Children> getChildren(){
        return this.children;
    }
    public void setAttributes(List<Attributes> attributes){
        this.attributes = attributes;
    }
    public List<Attributes> getAttributes(){
        return this.attributes;
    }
}
