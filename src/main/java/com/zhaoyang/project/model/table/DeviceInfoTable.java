package com.zhaoyang.project.model.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DeviceInfoTable{
	
	
	@Id
	@GeneratedValue
    private long id;
	
	@Column(nullable = false)
    private String name;
	@Column(nullable = false)
    private String siteToken;
	@Column(nullable = false)
    private String specToken;

	@Column(nullable = false)
    private String specName;
	
	@Column(nullable = false)
    private String type;
	
	@Column(nullable = false)
    private long userId ;
	
    public DeviceInfoTable(){}

    public DeviceInfoTable(String name, String siteToken, String specToken,String specName,String type,long userId) {
        this.name = name;
        this.siteToken = siteToken;
        this.specToken =specToken;
        this.type=type;
        this.specName=specName;
        this.userId=userId;
    }
	
    public void setId(long id){
    	this.id = id;
    }
    public long getId()	{
    	return this.id;
    }
    public void setUserId(long userId){
    	this.userId = userId;
    }
    public long getUserId()	{
    	return this.userId;
    }
    
    
    public void setSpecName(String specName){
        this.specName = specName;
    }
    public String getSpecName(){
        return this.specName;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setSiteToken(String siteToken){
        this.siteToken = siteToken;
    }
    public String getSiteToken(){
        return this.siteToken;
    }
    public void setSpecToken(String specToken){
        this.specToken = specToken;
    }
    public String getSpecToken(){
        return this.specToken;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
}

