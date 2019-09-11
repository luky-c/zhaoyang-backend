package com.zhaoyang.project.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zhaoyang.project.interfaces.UserRepository;
import com.zhaoyang.project.model.table.UserTable;



public class DbManager {
		@Autowired
		private UserRepository userRepository;
		
		public void insert(String name,int pwd,String unitName,String unitId){
			UserTable user = new UserTable();
			user.setName(name);
			user.setPwd(pwd);
			user.setUnitId(unitId);
			user.setUnitName(unitName);
			userRepository.save(user);
		}
		public void update(String name,int pwd,String unitName,String unitId,int id){
			UserTable user = new UserTable();
			user.setId(id);
			user.setName(name);
			user.setPwd(pwd);
			user.setUnitId(unitId);
			user.setUnitName(unitName);
			userRepository.save(user);
		}
		public void delete(long id){
			userRepository.delete(userRepository.findById(id));
		}
		public List<UserTable> select(String name){
			return userRepository.findByName(name);
		}
		
}
