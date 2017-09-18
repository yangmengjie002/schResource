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
	//使用指定类初始化日志对象，在日志输出的时候，可以打印出日志信息所在类
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
	        String ctxpath = request.getContextPath();//获取工程名部分

	        if(user != null){
	        	chain.doFilter(req,resp);  
	        } else{
	        	if (request.getHeader("x-requested-with") != null 
                        && "XMLHttpRequest".equalsIgnoreCase(request.getHeader("x-requested-with"))) {//判断是否为ajax提交
	        		//向http头添加 状态 sessionstatus
                    response.setHeader("sessionstatus","timeout");
                    response.setStatus(403);
                    //向http头添加登录的url
                    response.addHeader("loginPath", "/schResource/loginqian/index.jsp");
                    chain.doFilter(request, response);
                    log.debug("ajax request");
                    return;
                }
	            response.sendRedirect("/schResource/loginqian/index.jsp");
	        }  
	}
	
	/*//ajax完成时回调函数 js页面配置拦截结果
	$(document).ajaxComplete(function(event, xhr, settings) {
	    //从http头信息取出 在filter定义的sessionstatus，判断是否是 timeout
	    if(xhr.getResponseHeader("sessionstatus")=="timeout"){ 
	        //从http头信息取出登录的url ＝ loginPath
	        if(xhr.getResponseHeader("loginPath")){
	            alert("会话过期，请重新登陆!");
	            //打会到登录页面
	            window.location.replace(xhr.getResponseHeader("loginPath"));  
	        }else{  
	            alert("请求超时请重新登陆 !");  
	        }  
	    }  
	}); */

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}



}
