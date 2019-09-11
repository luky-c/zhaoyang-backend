package com.zhaoyang.project.model.SpecCommondBean;

import java.util.List;

public class SpecCommondBean {
    public SpecCommondBean(){}
    private String name;

    private String namespace;

    private String description;

    private List<Parameters> parameters ;

    private Metadata metadata;

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
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
    public void setParameters(List<Parameters> parameters){
        this.parameters = parameters;
    }
    public List<Parameters> getParameters(){
        return this.parameters;
    }
    public void setMetadata(Metadata metadata){
        this.metadata = metadata;
    }
    public Metadata getMetadata(){
        return this.metadata;
    }

}
