package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.UserModel;

public interface IUserDao {

	List<UserModel> findAll();
	
	UserModel findById(int id);
	
	void insert(UserModel user);
	
	
	void insertregister(UserModel user);
	
	void updatestatus1(UserModel user);
		
	boolean checkExitsUsername(String username);

	
	
	
}
