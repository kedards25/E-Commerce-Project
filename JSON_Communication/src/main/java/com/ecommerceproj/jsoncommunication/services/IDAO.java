package com.ecommerceproj.jsoncommunication.services;

import java.util.Map;
import java.util.List;

import com.ecommerceproj.jsoncommunication.models.UserModel;

public interface IDAO {

	List<UserModel> getAllUsers();

	int insertUser(UserModel model);

	int updateUser(int id, UserModel model);

	int deleteUser(int i);



}
