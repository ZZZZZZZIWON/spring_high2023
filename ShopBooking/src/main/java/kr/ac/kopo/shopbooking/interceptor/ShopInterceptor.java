package kr.ac.kopo.shopbooking.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.ac.kopo.shopbooking.model.Member;

public class ShopInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		
		Member member = (Member) session.getAttribute("member");
		
		if(member != null && member.getRole() >= Member.SHOP) {
			return true;
		}
		
		if(member == null)
			response.sendRedirect("/");
		else
			response.sendRedirect("/login");
		
		return false;
	}
	
	

}
