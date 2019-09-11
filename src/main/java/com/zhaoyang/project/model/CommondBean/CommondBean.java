package com.zhaoyang.project.model.CommondBean;

public class CommondBean {
    public CommondBean(){}
    private String eventDate;

    private boolean updateState;

    private String initiator;

    private String initiatorId;

    private String target;

    private String commandToken;

    private String sitewhereToken;

    private String assignToken;


    private String hardwareId;

    private ParameterValues parameterValues;

    public String getHardwareId() {
        return hardwareId;
    }

    public void setHardwareId(String hardwareId) {
        this.hardwareId = hardwareId;
    }
    public String getSitewhereToken() {
        return sitewhereToken;
    }

    public void setSitewhereToken(String sitewhereToken) {
        this.sitewhereToken = sitewhereToken;
    }

    public String getAssignToken() {
        return assignToken;
    }

    public void setAssignToken(String assignToken) {
        this.assignToken = assignToken;
    }

    public void setEventDate(String eventDate){
        this.eventDate = eventDate;
    }
    public String getEventDate(){
        return this.eventDate;
    }
    public void setUpdateState(boolean updateState){
        this.updateState = updateState;
    }
    public boolean getUpdateState(){
        return this.updateState;
    }
    public void setInitiator(String initiator){
        this.initiator = initiator;
    }
    public String getInitiator(){
        return this.initiator;
    }
    public void setInitiatorId(String initiatorId){
        this.initiatorId = initiatorId;
    }
    public String getInitiatorId(){
        return this.initiatorId;
    }
    public void setTarget(String target){
        this.target = target;
    }
    public String getTarget(){
        return this.target;
    }
    public void setCommandToken(String commandToken){
        this.commandToken = commandToken;
    }
    public String getCommandToken(){
        return this.commandToken;
    }
    public void setParameterValues(ParameterValues parameterValues){
        this.parameterValues = parameterValues;
    }
    public ParameterValues getParameterValues(){
        return this.parameterValues;
    }
}
