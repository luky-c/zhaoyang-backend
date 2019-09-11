package com.zhaoyang.project.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;

import com.zhaoyang.project.interfaces.AlertRepository;
import com.zhaoyang.project.model.table.AlertInfoTable;

public class DbAlertManager {
		@Autowired
		private  AlertRepository alertRepository;
		
		public void insert(String eventType,String deviceAssignmentToken,
		String assignmentType,String assetModuleId,String assetId,String eventDate,
		String receivedDate,String source,String level,String type,String message){
			AlertInfoTable alertIT = new AlertInfoTable();
			alertIT.setAssetId(assetId);
			alertIT.setAssetModuleId(assetModuleId);
			alertIT.setAssignmentType(assignmentType);
			alertIT.setDeviceAssignmentToken(deviceAssignmentToken);
			alertIT.setEventDate(eventDate);
			alertIT.setEventType(eventType);
			alertIT.setLevel(level);
			alertIT.setMessage(message);
			alertIT.setReceivedDate(receivedDate);
			alertIT.setSource(source);
			alertIT.setType(type);
			alertRepository.save(alertIT);
		}
		//单种设备按照页码查询，区分故障类别
		public  List<AlertInfoTable> getAlertInfo(String assignToken,String level,String type,String startDate,String endDate,int pageIndex,int pageSize){
			int start = (pageIndex-1)*pageSize;
			return alertRepository.getAlertInfo(assignToken,level,type,startDate,endDate,start,pageSize);
		}
		//单种设备全部类别错误查询
		public int getAllAlertorErrorInfo(String assignToken,String level,String startDate,String endDate){
			return alertRepository.getAllAlertInfoSize(assignToken,level,startDate,endDate).size();
		}
		//不区分设备
		public int getAllDeviceAlertorErrorInfo(String level,String startDate,String endDate){
			return alertRepository.getAllAlertInfo(level,startDate,endDate).size();
		}
		//卜区分设备，按照故障类别分类
		public int getAllDeviceAlertInfo(String level,String type,String startDate,String endDate){
			return alertRepository.getAllAlertInfo2(level,type,startDate,endDate).size();
		}
		//单种设备区分故障类别全部查询
		public int getAlertInfoExcPage(String assignToken,String level,String type,String startDate,String endDate){
			return alertRepository.getAllAlertInfo3(assignToken,level,type,startDate,endDate).size();
		}
		public String getLastTime(String assignToken){
			 return alertRepository.getEvenDate(assignToken);
			 }
		
}
