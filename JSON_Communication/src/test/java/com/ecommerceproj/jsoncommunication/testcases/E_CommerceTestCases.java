package com.ecommerceproj.jsoncommunication.testcases;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

import com.ecommerceproj.jsoncommunication.models.UserModel;
import com.ecommerceproj.jsoncommunication.services.IDAO;
import com.ecommerceproj.jsoncommunication.services.IDAO_Impl;


public class E_CommerceTestCases {

	IDAO dao=new IDAO_Impl();
	
	@Ignore
	public void getAllUsersTest()
	{
		List<UserModel> users=dao.getAllUsers();
		assertEquals(users.size()>0, true);
	}
	

	@Test
	public void inserUserTest()
	{
		UserModel model=new UserModel(102, "Kedar", "VPE", "123");
		assertEquals(dao.insertUser(model), 1);
	}
	
	@Ignore
	public void updateUserTest()
	{
		UserModel model=new UserModel(101, "Bala", "Chennai", "123");
		assertEquals(dao.updateUser(101,model)>0, true);
	}
	
	@Ignore
	public void deleteUserTest()
	{
		assertEquals(dao.deleteUser(101)>0, true);
	}
	
	
	
	
}
