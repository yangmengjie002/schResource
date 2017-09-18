package sch.com.entity;

import java.util.Date;

public class QueryEntity {
	private String resourceName;//��Դ��
	private String username;//��ϵ��
	private Integer instituteId;
	private Integer majorId;
	private Integer typeId;//��Դ����
	private String startDate;//��ʼʱ��
	private String endDate;//����ʱ��
	private Integer minCount;//��С������
	private Integer maxCount;//���������
	private Integer page;
	private Integer rows;
	private Integer startIndex;
	private Integer endIndex;
	
	public Integer getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}
	public Integer getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(Integer endIndex) {
		this.endIndex = endIndex;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getInstituteId() {
		return instituteId;
	}
	public void setInstituteId(Integer instituteId) {
		this.instituteId = instituteId;
	}
	public Integer getMajorId() {
		return majorId;
	}
	public void setMajorId(Integer majorId) {
		this.majorId = majorId;
	}
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public Integer getMinCount() {
		return minCount;
	}
	public void setMinCount(Integer minCount) {
		this.minCount = minCount;
	}
	public Integer getMaxCount() {
		return maxCount;
	}
	public void setMaxCount(Integer maxCount) {
		this.maxCount = maxCount;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	@Override
	public String toString() {
		return "QueryEntity [resourceName=" + resourceName + ", username=" + username + ", instituteId=" + instituteId
				+ ", majorId=" + majorId + ", startDate=" + startDate + ", endDate=" + endDate + ", minCount="
				+ minCount + ", maxCount=" + maxCount + ", page=" + page + ", rows=" + rows + "]";
	}
	
	
}
