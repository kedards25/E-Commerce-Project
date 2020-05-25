package com.learning.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class ProcessData
 */
@WebServlet("/ProcessData")
public class ProcessData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String uName=request.getParameter("usrNm");
//		String uPwd=request.getParameter("usrPwd");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("application/json");
		Gson g=new Gson();
//		Map<String, String> hashMap=new HashMap();
//		hashMap=(Map<String, String>)g.fromJson(request.getReader(),Map.class);
		//String val=(String)g.fromJson(request.getReader(), String.class);
		UserModel model=g.fromJson(request.getReader(),UserModel.class);
//		BufferedReader br=request.getReader();
//		String resp = new String();
//		for (String line; (line = br.readLine()) != null; resp += line);
		System.out.println(model);
		//System.out.println(val);
		//System.out.println("value "+hashMap);
		//System.out.println(request.getParameter("user"));
		
		
		//HashMap to send response as JSON
		Map resultMap=new HashMap();
		resultMap.put("isDataReceived", true);
		
		response.getWriter().print(g.toJson(model));
		
//		System.out.println(hashMap.get("name"));
//		System.out.println(hashMap.get("pass"));
//		String data=(String)g.fromJson(request.getReader(), String.class);
		//response.getWriter().print("Done");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
