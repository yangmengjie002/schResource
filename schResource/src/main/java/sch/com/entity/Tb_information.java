package sch.com.entity;

public class Tb_information {
	/**
	 * ��Ѷ��
	 */
	int informationID;			//��Ѷ����
	String informationTitle;	//��ѯ����
	String informationContent;	//��ѯ����
	int user_id;				//׫д��id
	public int getInformationID() {
		return informationID;
	}
	public void setInformationID(int informationID) {
		this.informationID = informationID;
	}
	public String getInformationTitle() {
		return informationTitle;
	}
	public void setInformationTitle(String informationTitle) {
		this.informationTitle = informationTitle;
	}
	public String getInformationContent() {
		return informationContent;
	}
	public void setInformationContent(String informationContent) {
		this.informationContent = informationContent;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
}
