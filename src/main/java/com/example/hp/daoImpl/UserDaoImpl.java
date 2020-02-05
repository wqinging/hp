//package com.example.hp.daoImpl;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import dao.BaseDao;
//import dao.UserDao;
//import domian.PubHouse;
//import domian.User;
//
//public class UserDaoImpl extends BaseDao implements UserDao {
//
//	@Override
//	public User checkUser(User user) {
//		super.conn = super.getConnection();
//		String sql = "select * from user where phone_number = ?";
//		User u = new User();
//		try {
//			super.pstm = conn.prepareStatement(sql);
//			pstm.setString(1, user.getPassword());
//			super.rs = pstm.executeQuery();
//			while (rs.next()) {
//				u = new User(rs.getInt("id"), rs.getString("name"), rs.getString("password"),
//						rs.getString("phone_number"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				super.closeAll();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//		return u;
//	}
//
//	@Override
//	public void insertUser(User user) {
//		super.conn = super.getConnection();
//		String sql = "insert into user(phone_number) values(?)";
//		try {
//			super.pstm = conn.prepareStatement(sql);
//			pstm.setString(1, user.getPhoneNumber());
//			pstm.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				super.closeAll();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//	}
//
//	@Override
//	public void insertPHouse(PubHouse pubHouse) {
//		super.conn = super.getConnection();
//		String sql = "INSERT INTO `pubhouseinfo`(`user_phone`,`city`,`area`,`build`,`unit`,`sign`,`price`)VALUES\r\n"
//				+ "(?,?,?,?,?,?,?) ";
//		try {
//			super.pstm = conn.prepareStatement(sql);
//			pstm.setString(1, pubHouse.getUserPhone());
//			pstm.setString(2, pubHouse.getCity());
//			pstm.setString(3, pubHouse.getArea());
//			pstm.setString(4, pubHouse.getBuild());
//			pstm.setString(5, pubHouse.getUnit());
//			pstm.setString(6, pubHouse.getSignum());
//			pstm.setString(7, pubHouse.getPrice());
//			pstm.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				super.closeAll();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
//
//	@Override
//	public List<PubHouse> findPHouse(String pNumber) {
//		super.conn = super.getConnection();
//		String sql = "select * from pubhouseinfo where user_phone = ?";
//		List<PubHouse> pHouseList = new ArrayList<>();
//		try {
//
//			super.pstm = conn.prepareStatement(sql);
//			pstm.setString(1, pNumber);
//			super.rs = pstm.executeQuery();
//			while (rs.next()) {
//				PubHouse pubHouse = new PubHouse(rs.getInt("id"), rs.getString("user_phone"), rs.getString("city"),
//						rs.getString("area"), rs.getString("build"), rs.getString("unit"), rs.getString("sign"),
//						rs.getString("price"));
//				pHouseList.add(pubHouse);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				super.closeAll();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return pHouseList;
//
//	}
//
//	@Override
//	public User checkUserByPassword(User user) {
//		super.conn = super.getConnection();
//		User u = new User();
//		String sql = "select * from user where phone_number = ? and password = ?";
//		try {
//			super.pstm = conn.prepareStatement(sql);
//			pstm.setString(1, user.getPhoneNumber());
//			pstm.setString(2, user.getPassword());
//			super.rs = pstm.executeQuery();
//			while (rs.next()) {
//				u = new User(rs.getInt("id"), rs.getString("name"), rs.getString("password"),
//						rs.getString("phone_number"));
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				super.closeAll();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return u;
//	}
//
//	@Override
//	public void updateUser(User user) {
//		super.conn = super.getConnection();
//		String sql = "update user set name = ?,password = ? where phone_number = ?";
//		try {
//			super.pstm = conn.prepareStatement(sql);
//			pstm.setString(1, user.getName());
//			pstm.setString(2, user.getPassword());
//			pstm.setString(3, user.getPhoneNumber());
//			pstm.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				super.closeAll();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//	}
//
//	@Override
//	public void deletePHouse(int id) {
//		super.conn = super.getConnection();
//		String sql = "delete from pubhouseinfo where id = ?";
//		try {
//			super.pstm = conn.prepareStatement(sql);
//			pstm.setInt(1, id);
//			pstm.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				super.closeAll();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//	}
//
//}
