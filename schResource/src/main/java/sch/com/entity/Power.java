package sch.com.entity;

public class Power {
	private Integer powerId;//����ID
	private String powerName;//Ȩ����
	private String powerKey;//Ȩ�޹ؼ���
	private String powerView="1";//�Ƿ���ʾ�ڲ˵���1Ϊ��ʾ����Ϊ����ʾ
	private String powerStatus="1";//Ȩ���Ƿ����1 Ϊ���ã�2Ϊ������
	private String powerRoad;//Ȩ��·��
	private String powerPriority;//Ȩ�����ȼ���������ʾ����
	private String powerPid;//����Ȩ��
	
	public Integer getPowerId() {
		return powerId;
	}
	public void setPowerId(Integer powerId) {
		this.powerId = powerId;
	}
	public String getPowerName() {
		return powerName;
	}
	public void setPowerName(String powerName) {
		this.powerName = powerName;
	}
	public String getPowerKey() {
		return powerKey;
	}
	public void setPowerKey(String powerKey) {
		this.powerKey = powerKey;
	}
	public String getPowerView() {
		return powerView;
	}
	public void setPowerView(String powerView) {
		this.powerView = powerView;
	}
	
	public String getPowerStatus() {
		return powerStatus;
	}
	public void setPowerStatus(String powerStatus) {
		this.powerStatus = powerStatus;
	}
	public String getPowerRoad() {
		return powerRoad;
	}
	public void setPowerRoad(String powerRoad) {
		this.powerRoad = powerRoad;
	}
	public String getPowerPriority() {
		return powerPriority;
	}
	public void setPowerPriority(String powerPriority) {
		this.powerPriority = powerPriority;
	}
	public String getPowerPid() {
		return powerPid;
	}
	public void setPowerPid(String powerPid) {
		this.powerPid = powerPid;
	}
	
	
}
