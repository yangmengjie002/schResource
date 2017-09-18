package sch.com.entity;

/**
 * 资源管理条件查询参数
 * @author xiaoming
 *
 */
public class ResourceParam {
	private String uploadDate;
	private String resourceName;
	
	public String getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	
}
