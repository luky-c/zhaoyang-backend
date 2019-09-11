package com.zhaoyang.project.model.table;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AlertInfoTable {


	@Id
	@GeneratedValue
	        private String id;
	@Column(nullable = false)
	        private String eventType;

	@Column(nullable = false)
	        private String deviceAssignmentToken;
	@Column(nullable = false)
	        private String assignmentType;
	@Column(nullable = false)
	        private String assetModuleId;
	@Column(nullable = false)
	        private String assetId;
	@Column(nullable = false)
	        private String eventDate;
	@Column(nullable = false)
	        private String receivedDate;
	@Column(nullable = false)
	        private String source;
	@Column(nullable = false)
	        private String level;
	@Column(nullable = false)
	        private String type;
	@Column(nullable = false)
	        private String message;

	
	public AlertInfoTable(){};
	public AlertInfoTable(String eventType,String deviceAssignmentToken,
			String assignmentType,String assetModuleId,String assetId,String eventDate,
			String receivedDate,String source,String level,String type,String message){
		
		 this.eventType = eventType;
		
		 this.deviceAssignmentToken = deviceAssignmentToken;
		 this.assignmentType = assignmentType;
		 this.assetModuleId = assetModuleId;
		 this.assetId = assetId;
		 this.eventDate = eventDate;
		 this.receivedDate = receivedDate;
		 this.source = source;
		 this.level = level;
		 this.type = type;
		 this.message = message;
	}
	



	        public void setId(String id) {
	            this.id = id;
	        }
	        public String getId() {
	            return id;
	        }

	        public void setEventType(String eventType) {
	            this.eventType = eventType;
	        }
	        public String getEventType() {
	            return eventType;
	        }



	        public void setDeviceAssignmentToken(String deviceAssignmentToken) {
	            this.deviceAssignmentToken = deviceAssignmentToken;
	        }
	        public String getDeviceAssignmentToken() {
	            return deviceAssignmentToken;
	        }

	        public void setAssignmentType(String assignmentType) {
	            this.assignmentType = assignmentType;
	        }
	        public String getAssignmentType() {
	            return assignmentType;
	        }

	        public void setAssetModuleId(String assetModuleId) {
	            this.assetModuleId = assetModuleId;
	        }
	        public String getAssetModuleId() {
	            return assetModuleId;
	        }

	        public void setAssetId(String assetId) {
	            this.assetId = assetId;
	        }
	        public String getAssetId() {
	            return assetId;
	        }

	        public void setEventDate(String eventDate) {
	            this.eventDate = eventDate;
	        }
	        public String getEventDate() {
	            return eventDate;
	        }

	        public void setReceivedDate(String receivedDate) {
	            this.receivedDate = receivedDate;
	        }
	        public String getReceivedDate() {
	            return receivedDate;
	        }

	        public void setSource(String source) {
	            this.source = source;
	        }
	        public String getSource() {
	            return source;
	        }

	        public void setLevel(String level) {
	            this.level = level;
	        }
	        public String getLevel() {
	            return level;
	        }

	        public void setType(String type) {
	            this.type = type;
	        }
	        public String getType() {
	            return type;
	        }

	        public void setMessage(String message) {
	            this.message = message;
	        }
	        public String getMessage() {
	            return message;
	        }
	
}
