package com.zhaoyang.project.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zhaoyang.project.interfaces.AdminUserRepository;
import com.zhaoyang.project.model.table.AdminUserTable;



public class DbAdminUserManager {
		@Autowired
		private AdminUserRepository adminUserRepository;
		public void insert(String name,String password,String hashedPassword){
			AdminUserTable adminUser = new AdminUserTable();
			adminUser.setHashedPassword(hashedPassword);
			adminUser.setPassword(password);
			adminUser.setUsername(name);
			adminUserRepository.save(adminUser);
		}
		public void update(String name,String password,String hashedPassword,int id){
			AdminUserTable adminUser = new AdminUserTable();
			adminUser.setId(id);
			adminUser.setHashedPassword(hashedPassword);
			adminUser.setPassword(password);
			adminUser.setUsername(name);
			adminUserRepository.save(adminUser);
		}
		 public void delete(long id){
			 adminUserRepository.deleteById(id);
		 }
		 public List<AdminUserTable> select(String name){
			 return adminUserRepository.findByUsername(name);
		 }
		 
}
