package com.zhaoyang.project.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zhaoyang.project.model.table.DeviceInfoTable;



public interface DeviceRepository extends JpaRepository<DeviceInfoTable, Long>{
	DeviceInfoTable findById(long id);
	List<DeviceInfoTable> findByUserId(long userId);
    List<DeviceInfoTable> findByName(String name);
}
