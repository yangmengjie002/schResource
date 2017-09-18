package sch.com.interceptors;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sch.com.entity.User;

public class UserFilter implements Filter{
	//ʹ��ָ�����ʼ����־��������־�����ʱ�򣬿��Դ�ӡ����־��Ϣ������
	private static Logger log = LoggerFactory.getLogger(UserFilter.class);
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		 	HttpServletRequest request = (HttpServletRequest)req;  
	        HttpServletResponse response = (HttpServletResponse)resp;  
	        request.setCharacterEncoding("UTF-8");  
	        response.setContentType("text/html;charset=UTF-8");  
	        HttpSession session = request.getSession();   
	        User user = (User)session.getAttribute("user");
	       /* request.getRequestURL() http://localhost:8080/jqueryLearn/resources/request.jsp 
        	request.getRequestURI() /jqueryLearn/resources/request.jsp
        	request.getContextPath()/jqueryLearn 
        	request.getServletPath()/resources/request.jsp */

	        String uri = request.getRequestURI();
	        String ctxpath = request.getContextPath();//��ȡ����������

	        if(user != null){
	        	chain.doFilter(req,resp);  
	        } else{
	        	if (request.getHeader("x-requested-with") != null 
                        && "XMLHttpRequest".equalsIgnoreCase(request.getHeader("x-requested-with"))) {//�ж��Ƿ�Ϊajax�ύ
	        		//��httpͷ��� ״̬ sessionstatus
                    response.setHeader("sessionstatus","timeout");
                    response.setStatus(403);
                    //��httpͷ��ӵ�¼��url
                    response.addHeader("loginPath", "/schResource/loginqian/index.jsp");
                    chain.doFilter(request, response);
                    log.debug("ajax request");
                    return;
                }
	            response.sendRedirect("/schResource/loginqian/index.jsp");
	        }  
	}
	
	/*//ajax���ʱ�ص����� jsҳ���������ؽ��
	$(document).ajaxComplete(function(event, xhr, settings) {
	    //��httpͷ��Ϣȡ�� ��filter�����sessionstatus���ж��Ƿ��� timeout
	    if(xhr.getResponseHeader("sessionstatus")=="timeout"){ 
	        //��httpͷ��Ϣȡ����¼��url �� loginPath
	        if(xhr.getResponseHeader("loginPath")){
	            alert("�Ự���ڣ������µ�½!");
	            //��ᵽ��¼ҳ��
	            window.location.replace(xhr.getResponseHeader("loginPath"));  
	        }else{  
	            alert("����ʱ�����µ�½ !");  
	        }  
	    }  
	}); */

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}



}
