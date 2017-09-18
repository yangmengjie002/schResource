package sch.com.web.yang;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ch.qos.logback.core.joran.action.ActionUtil.Scope;
import sch.com.entity.Power;
import sch.com.entity.User;
import sch.com.service.yang.FunctionService;
import sch.com.service.yang.UserService;

/**
 * realm����ӿڵ��Զ��巽��������jdbcrealm
 * @author yang
 *
 */
public class BosRealm extends AuthorizingRealm{
	@Resource
	private UserService ut;
	@Resource
	private FunctionService fs;
	/**
	 * ��֤����
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		System.out.println("��֤����������");
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();// �������л���û���
		System.out.println(username);
		User user =ut.getUser(username);
		System.out.println(user.getUserName());
		if (user == null) {
			// �û���������
			return null;
		} else {
			// �û�������
			String password = user.getUserPwd();// ������ݿ��д洢������
			// ��������֤��Ϣ����
			/***
			 * ����һ��ǩ�����������������λ�û�ȡ��ǰ����Ķ���
			 * �������������ݿ��в�ѯ��������
			 * ����������ǰrealm������
			 */
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,
					password, this.getClass().getSimpleName());
			return info;//���ظ���ȫ���������ɰ�ȫ����������ȶ����ݿ��в�ѯ���������ҳ���ύ������
		}
	}

	/**
	 * ��Ȩ����
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		//���ݵ�ǰ��¼�û���ѯ���Ӧ��Ȩ�ޣ���Ȩ
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		User user = (User) principals.getPrimaryPrincipal();//��ȡ�û�
		List<Map<String,Object>> list = null;//��ȡ�û�Ȩ��
		/*if(user.getUserName().equals("admin")){
			//�û�Ϊ��������Ա����ȡ����Ȩ�ޡ�
			list = fs.functionQuery();
		}else{*/
			//�û�Ϊ��ͨ�û�������id��ȡȨ��
			list = fs.functionQueryByUserId(user.getUserId());
		/*}*/
		//��Ȩ�޸�����֤����
		for (int i = 0; i < list.size(); i++) {
			String key = list.get(i).get("POWER_KEY")+"";
			info.addStringPermission(key);
		}
		return info;
	}



}
