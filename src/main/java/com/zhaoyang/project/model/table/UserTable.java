package com.zhaoyang.project.model.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserTable {
    @Id
 	@GeneratedValue
 	private long id;
    
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int pwd;
    @Column(nullable = false)
    private String unitName;
    @Column(nullable = false)
    private String unitId;
    
    public UserTable(){};
    
    public UserTable(String name,int pwd,String unitName,String unitId){
    	this.name=name;
    	this.pwd=pwd;
    	this.unitName=unitName;
    	this.unitId=unitId;
    }
    
    public void setId(long id){
    	this.id = id;
    }
    public long getId()	{
    	return this.id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setPwd(int pwd){
        this.pwd = pwd;
    }
    public int getPwd(){
        return this.pwd;
    }
    public void setUnitName(String unitName){
        this.unitName = unitName;
    }
    public String getUnitName(){
        return this.unitName;
    }
    public void setUnitId(String unitId){
        this.unitId = unitId;
    }
    public String getUnitId(){
        return this.unitId;
    }

    

    
     
}
