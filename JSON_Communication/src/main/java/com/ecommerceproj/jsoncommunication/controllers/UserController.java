package com.ecommerceproj.jsoncommunication.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerceproj.jsoncommunication.models.UserModel;
import com.ecommerceproj.jsoncommunication.services.IDAO;
import com.ecommerceproj.jsoncommunication.services.IDAO_Impl;
import com.google.gson.Gson;

/**
 * Servlet implementation class UserController
 */
public class UserController extends HttpServlet {

	RequestDispatcher dispatcher = null;
	IDAO idao;

	public UserController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String urlPath = request.getServletPath();		
		response.setContentType("application/json");
		switch (urlPath) {
		case "/":

			dispatcher = request.getRequestDispatcher("/views/index.jsp");
			dispatcher.forward(request, response);
			break;

		case "/display":
			idao = new IDAO_Impl();
			List<UserModel> userMap = new ArrayList<UserModel>();

			// fetching data from IDAO service
			userMap = idao.getAllUsers();

			// converting MAP object to JSON
			Gson gson = new Gson();
			String user = gson.toJson(userMap);
			response.getWriter().print(user);
			break;

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
