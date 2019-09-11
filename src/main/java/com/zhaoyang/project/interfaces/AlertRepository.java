package com.zhaoyang.project.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zhaoyang.project.model.table.AlertInfoTable;



public interface AlertRepository extends JpaRepository<AlertInfoTable, Long>{
	@Query("from AlertInfoTable ai where ai.deviceAssignmentToken=:deviceAssignmentToken and"
			+ "ai.level=:level and ai.type=:type and ai.eventDate>=:startDate and ai.eventDate<=:endDate order by eventDate desc limit :start,:pageSize")
	List<AlertInfoTable> getAlertInfo(@Param("deviceAssignmentToken") String deviceAssignmentToken,@Param("level") String level,@Param("type") String type,
			@Param("startDate") String startDate,@Param("endDate") String endDate,@Param("start") int start,@Param("pageSize") int pageSize);
	@Query("from AlertInfoTable ai where ai.deviceAssignmentToken=:deviceAssignmentToken and"
			+ "ai.level=:level  and ai.eventDate>=:startDate and ai.eventDate<=:endDate order by eventDate" )
	List<AlertInfoTable> getAllAlertInfoSize(@Param("deviceAssignmentToken") String deviceAssignmentToken,@Param("level") String level,
			@Param("startDate") String startDate,@Param("endDate") String endDate);
	@Query("from AlertInfoTable ai where "
			+ "ai.level=:level  and ai.eventDate>=:startDate and ai.eventDate<=:endDate order by eventDate" )
	List<AlertInfoTable> getAllAlertInfo(@Param("level") String level,
			@Param("startDate") String startDate,@Param("endDate") String endDate);	
	@Query("from AlertInfoTable ai where ai.type=:type and"
			+ "ai.level=:level  and ai.eventDate>=:startDate and ai.eventDate<=:endDate order by eventDate" )
	List<AlertInfoTable> getAllAlertInfo2(@Param("level") String level,@Param("type") String type,
			@Param("startDate") String startDate,@Param("endDate") String endDate);
	@Query("from AlertInfoTable ai where ai.deviceAssignmentToken=:deviceAssignmentToken and"
			+ "ai.level=:level and ai.type=:type and ai.eventDate>=:startDate and ai.eventDate<=:endDate order by eventDate")
	List<AlertInfoTable> getAllAlertInfo3(@Param("deviceAssignmentToken") String deviceAssignmentToken,@Param("level") String level,@Param("type") String type,
			@Param("startDate") String startDate,@Param("endDate") String endDate);
	@Query("SELECT eventDate FROM AlertInfoTable ai where  ai.deviceAssignmentToken= :deviceAssignmentToken order by eventDate desc limit 1")
	String getEvenDate(@Param("deviceAssignmentToken") String deviceAssignmentToken);
}
