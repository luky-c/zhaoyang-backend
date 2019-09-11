package com.zhaoyang.project.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zhaoyang.project.model.table.UserTable;



public interface UserRepository extends JpaRepository<UserTable, Long>{

	UserTable findById(long id);
	List<UserTable> findByName(String name);

}
