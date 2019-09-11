package com.zhaoyang.project.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zhaoyang.project.model.table.AdminUserTable;

public interface AdminUserRepository extends JpaRepository<AdminUserTable, Long> {
	List<AdminUserTable> findByUsername(String name);
	
}
