package com.zhaoyang.project.model.TenantConf.Children;

public class Attributes {
    public Attributes(){}
    private String name;
    private String namespace;


    private String value;
    public void setNamespace(String namespace){
        this.namespace = namespace;
    }
    public String getNamespace(){
        return this.namespace;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setValue(String value){
        this.value = value;
    }
    public String getValue(){
        return this.value;
    }
}
