package com.zhaoyang.project.model.SpecCommondBean;

public class Parameters {
    public Parameters(){}
    private String name;

    private String type;

    private boolean required;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void setRequired(boolean required){
        this.required = required;
    }
    public boolean getRequired(){
        return this.required;
    }
}
