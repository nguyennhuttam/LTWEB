package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;

import vn.iotstar.configs.DBConnectMySQL;
import vn.iotstar.configs.DBConnectSQL;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.models.UserModel;

public class UserDaoImpl extends DBConnectMySQL implements IUserDao {

	public Connection  conn = null;
	@SuppressWarnings("rawtypes")
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	
	
	@Override
	public List<UserModel> findAll() {
		String sql ="select * from users";
		List<UserModel> list = new ArrayList<>(); //tao 1 list de truyen du lieu
		 
		try {
			conn = super.getDatabaseConnection();// ket noi database
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next() /*next tung dong toi cuoi ban*/) {
				list.add(
						new UserModel(
								rs.getInt("id"), 
								rs.getString("username"),
								rs.getString("password"),
								rs.getString("email"),
								rs.getString("fullname"),
								rs.getString("images")
								)
						); //Add vao
			}
			return list;
			
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
				
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	@Override
	public UserModel findById(int id) {
		
		
		
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(UserModel user) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO users(id, username, email, password, images, fullname) VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
			conn = super.getDatabaseConnection(); // ket noi database
			
			ps = conn.prepareStatement(sql); //nem cau sql vao cho thuc thi
			
			ps.setInt(1, user.getId());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getImages());
			ps.setString(6, user.getFullname());
			
			ps.executeLargeUpdate();
			
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		
	}

	
	@Override
	public void insertrehister(UserModel user) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO users(username, email, password, fullname) VALUES (?, ?, ?, ?, ?)";
		
		try {
			conn = super.getDatabaseConnection(); // ket noi database
			
			ps = conn.prepareStatement(sql); //nem cau sql vao cho thuc thi
			
			
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getFullname());
			
			ps.executeLargeUpdate();
			
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		
	}
	
	
	@Override
	public void updatestatus1(UserModel user) {
		// TODO Auto-generated method stub
		String sql = "UPDATE [UserMode] SET status=?, WHERE email=?";
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getEmail());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generted catch block
			e.printStackTrace();
		}
	}
	
	
	
	

	@Override
	public boolean checkExitstUsername(String username) {
		boolean duplicate = false;
		String sql = "Select * From Users where username =?";
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs=ps.executeQuery();
			if(rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return duplicate;
	}
	
	
	
	
	
	public static void main(String[] agr) {
		
		UserDaoImpl userDao = new UserDaoImpl();
		
		//userDao.insert(new UserModel(2,"abc","abc@gmail.com","123","Nguyen Nhut Tam","abcdef"));
		
		// Sytem.out.println(userDao.findOne(1);
		List<UserModel> list = userDao.findAll();
		
		for (UserModel user : list) {
			System.out.println(user);
			
		}
	}




	@Override
	public void insertregister(UserModel user) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void updatestatus(UserModel user) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public boolean checkExitsUsername(String username) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
