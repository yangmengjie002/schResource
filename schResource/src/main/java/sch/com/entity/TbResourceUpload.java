package sch.com.entity;

/**
 * ��Դ�ϴ�ʵ����
 * @author xiaoming
 *
 */
public class TbResourceUpload {
	private int resource_id;            //��Դ���
	private int resource_type_id;       //��Դ���id
	private int user_id;				//�ϴ���id
	private String upload_site;         //�洢��ַ
	private String upload_date;			//�ϴ�ʱ��
	private int status_id; 				//״̬���
	private int major_id;				//����ԺϵID
	public int getResource_id() {
		return resource_id;
	}
	public void setResource_id(int resource_id) {
		this.resource_id = resource_id;
	}
	public int getResource_type_id() {
		return resource_type_id;
	}
	public void setResource_type_id(int resource_type_id) {
		this.resource_type_id = resource_type_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUpload_site() {
		return upload_site;
	}
	public void setUpload_site(String upload_site) {
		this.upload_site = upload_site;
	}
	public String getUpload_date() {
		return upload_date;
	}
	public void setUpload_date(String upload_date) {
		this.upload_date = upload_date;
	}
	public int getStatus_id() {
		return status_id;
	}
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	public int getMajor_id() {
		return major_id;
	}
	public void setMajor_id(int major_id) {
		this.major_id = major_id;
	}
	
	
}
