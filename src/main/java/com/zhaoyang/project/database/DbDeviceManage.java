package com.zhaoyang.project.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zhaoyang.project.interfaces.DeviceRepository;
import com.zhaoyang.project.model.table.DeviceInfoTable;



public class DbDeviceManage {
		@Autowired
		private DeviceRepository deviceRepository;
		
		public void insert(String name,String siteToken,String specToken,String specName,long userId){
			DeviceInfoTable DT = new DeviceInfoTable();
			DT.setName(name);
			DT.setSiteToken(siteToken);
			DT.setUserId(userId);
			DT.setSpecToken(specToken);
			DT.setSpecName(specName);
			deviceRepository.save(DT);
		}
		 public void update(String name,String siteToken,String specToken,String specName,long id,long userId){
				DeviceInfoTable DT = new DeviceInfoTable();
				DT.setId(id);
				DT.setName(name);
				DT.setSiteToken(siteToken);
				DT.setUserId(userId);
				DT.setSpecToken(specToken);
				DT.setSpecName(specName);
				deviceRepository.save(DT);			 
		 }
		 public void delete(long id  ){
			 deviceRepository.deleteById(id);;
		 }
		 public List<DeviceInfoTable> select(String name){
			 return deviceRepository.findByName(name);
		 }
		 public DeviceInfoTable selectById(long id){
			 return deviceRepository.findById(id);
		 }
		 public List<DeviceInfoTable> selectByUserId(long userId){
			 return deviceRepository.findByUserId(userId);
		 }
		 
}
