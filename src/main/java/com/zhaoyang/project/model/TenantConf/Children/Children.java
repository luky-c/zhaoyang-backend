package com.zhaoyang.project.model.TenantConf.Children;



import java.util.List;


public class Children {
    public Children(){}
    private String name;

    private String namespace;

    private String id;

    private List<Attributes> attributes ;
    private List<Children> children ;

    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }




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
    public void setAttributes(List<Attributes> attributes){
        this.attributes = attributes;
    }
    public List<Attributes> getAttributes(){
        return this.attributes;
    }

}
