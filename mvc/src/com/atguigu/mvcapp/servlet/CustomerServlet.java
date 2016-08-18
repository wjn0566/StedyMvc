package com.atguigu.mvcapp.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


/*	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		switch (method){
		case "add": add(request,response); break;
		case "query": query(request,response); break;
		case "delete": delete(request,response); break;
		}
	}
*/
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1.取ServletPath，如/add.do /edit.do
		String servletPath = req.getServletPath();
		String methodName = servletPath.substring(1);
		//2.去除前部的/ 和后面的.do,得到名称
		methodName = methodName.substring(0,methodName.length()-3);
		try {
			//使用反射机制获取methodName对应的方法
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			//利用反射调用对应的方法
			method.invoke(this, req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("delete");
		
	}


	private void query(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("query");		
	}


	private void add(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("add");		
	}

}
