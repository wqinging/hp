//package com.example.hp.daoImpl;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import dao.BaseDao;
//import dao.HouseDao;
//import domian.Agent;
//import domian.House;
//import domian.Page;
//
//public class HouseDaoImpl extends BaseDao implements HouseDao {
//
//	@Override
//	public List<House> findHouse(String regiArg, String subArg, String rentArg, String areaArg, String typeArg,
//			Page page) {
//		List<House> houseList = new ArrayList<House>();
//		super.conn = super.getConnection();
//		String sql = "select * from houseinfo where 1=1 ";
//		StringBuffer sb = new StringBuffer(sql);
//		if (regiArg != null && regiArg != "") {
//			if (regiArg.equals("不限")) {
//				sb.append("");
//			} else {
//				sb.append(" and address like " + " concat('%','" + regiArg + "','%')");
//			}
//		}
//		if (subArg != null && subArg != "") {
//			if (subArg.equals("不限")) {
//
//			} else {
//				sb.append(" and subway like " + " concat('%','" + subArg + "','%')");
//			}
//		}
//		if (rentArg != null && rentArg != "") {
//			if (rentArg.equals("不限")) {
//
//			} else {
//				if (rentArg.indexOf("-") == -1) {
//					sb.append(" and price>3000");
//				} else if (rentArg.indexOf("-") != -1) {
//					String pa = rentArg.substring(0, rentArg.length() - 1);
//					String[] pas = pa.split("-");
//					int start = Integer.parseInt((pas[0]));
//					int end = Integer.parseInt((pas[1]));
//					sb.append(" and price between " + start + " and " + end);
//				}
//			}
//
//		}
//		if (areaArg != null && areaArg != "") {
//			if (areaArg.equals("不限")) {
//
//			} else {
//				if (areaArg.indexOf("-") == -1) {
//					sb.append(" and area>200");
//				} else if (areaArg.indexOf("-") != -1) {
//					String pa = areaArg.substring(0, areaArg.length() - 1);
//					String[] pas = pa.split("-");
//					double start = Double.parseDouble((pas[0]));
//					double end = Double.parseDouble((pas[1]));
//					sb.append(" and area between " + start + " and " + end);
//				}
//			}
//		}
//		if (typeArg != null && typeArg != "") {
//			if (typeArg.equals("不限")) {
//			} else if (typeArg.equals("4室以上")) {
//				sb.append(
//						" and house_type NOT LIKE CONCAT('%','1室','%') AND house_type NOT LIKE CONCAT('%','2室','%') AND house_type NOT LIKE CONCAT('%','3室','%') AND house_type NOT LIKE CONCAT('%','4室','%')");
//			} else {
//				sb.append(" and house_type like concat('%','" + typeArg + "','%')");
//			}
//
//		}
//		sb.append(" limit " + page.getStart() + "," + page.getSize());
//		try {
//			super.pstm = conn.prepareStatement(sb.toString());
//			super.rs = pstm.executeQuery();
//			while (rs.next()) {
//				House house = new House(rs.getString("name"), rs.getInt("price"), rs.getDouble("area"),
//						rs.getString("floor"), rs.getString("village"), rs.getString("house_type"),
//						rs.getString("address"), rs.getString("subway"), rs.getString("p_time"), rs.getString("ori"),
//						rs.getString("bulid_time"), rs.getString("rent_type"), rs.getString("image"));
//				houseList.add(house);
//
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
//		return houseList;
//	}
//
//	@Override
//	public int countHouse(String regiArg, String subArg, String rentArg, String areaArg, String typeArg) {
//		super.conn = super.getConnection();
//		int count = 0;
//		String sql = "select * from houseinfo where 1=1 ";
//		StringBuffer sb = new StringBuffer(sql);
//		if (regiArg != null && regiArg != "") {
//			if (regiArg.equals("不限")) {
//				sb.append("");
//			} else {
//				sb.append(" and address like " + " concat('%','" + regiArg + "','%')");
//			}
//		}
//		if (subArg != null && subArg != "") {
//			if (subArg.equals("不限")) {
//
//			} else {
//				sb.append(" and subway like " + " concat('%','" + subArg + "','%')");
//			}
//		}
//		if (rentArg != null && rentArg != "") {
//			if (rentArg.equals("不限")) {
//
//			} else {
//				if (rentArg.indexOf("-") == -1) {
//					sb.append(" and price>3000");
//				} else if (rentArg.indexOf("-") != -1) {
//					String pa = rentArg.substring(0, rentArg.length() - 1);
//					String[] pas = pa.split("-");
//					int start = Integer.parseInt((pas[0]));
//					int end = Integer.parseInt((pas[1]));
//					sb.append(" and price between " + start + " and " + end);
//				}
//			}
//
//		}
//		if (areaArg != null && areaArg != "") {
//			if (areaArg.equals("不限")) {
//
//			} else {
//				if (areaArg.indexOf("-") == -1) {
//					sb.append(" and area>200");
//				} else if (areaArg.indexOf("-") != -1) {
//					String pa = areaArg.substring(0, areaArg.length() - 1);
//					String[] pas = pa.split("-");
//					double start = Double.parseDouble((pas[0]));
//					double end = Double.parseDouble((pas[1]));
//					sb.append(" and area between " + start + " and " + end);
//				}
//			}
//		}
//		if (typeArg != null && typeArg != "") {
//			if (typeArg.equals("不限")) {
//			} else if (typeArg.equals("4室以上")) {
//				sb.append(
//						" and house_type NOT LIKE CONCAT('%','1室','%') AND house_type NOT LIKE CONCAT('%','2室','%') AND house_type NOT LIKE CONCAT('%','3室','%') AND house_type NOT LIKE CONCAT('%','4室','%')");
//			} else {
//				sb.append(" and house_type like concat('%','" + typeArg + "','%')");
//			}
//		}
//		try {
//			super.pstm = conn.prepareStatement(sb.toString());
//			super.rs = pstm.executeQuery();
//			while (rs.next()) {
//				count++;
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
//		return count;
//	}
//
//	@Override
//	public House showHouseByName(String name) {
//		super.conn = super.getConnection();
//		House house = new House();
//		Agent agent = new Agent();
//		String sql = "SELECT * FROM houseinfo h INNER JOIN agent a ON h.`agent` = a.`id` WHERE h.`name` = ?";
//		try {
//			super.pstm = conn.prepareStatement(sql);
//			pstm.setString(1, name);
//			super.rs = pstm.executeQuery();
//			while (rs.next()) {
//				house = new House(rs.getInt("h.id"), rs.getString("h.name"), rs.getInt("h.price"),
//						rs.getDouble("h.area"), rs.getString("h.floor"), rs.getString("h.village"),
//						rs.getString("h.house_type"), rs.getString("h.address"), rs.getString("h.subway"),
//						rs.getString("h.p_time"), rs.getString("h.ori"), rs.getString("h.bulid_time"),
//						rs.getString("h.rent_type"), rs.getString("h.image"), new Agent(rs.getInt("a.id"),
//								rs.getString("a.name"), rs.getString("a.phone_number"), rs.getString("a.image")));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				super.closeAll();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//
//		return house;
//	}
//
//	@Override
//	public List<House> searchHouseByName(String name) {
//		List<House> houseList = new ArrayList<House>();
//		super.conn = super.getConnection();
//		String sql = "select * from houseinfo where name like concat('%',?,'%') ";
//		try {
//			super.pstm = conn.prepareStatement(sql);
//			pstm.setString(1, name);
//			super.rs = pstm.executeQuery();
//			while (rs.next()) {
//				House house = new House(rs.getString("name"), rs.getInt("price"), rs.getDouble("area"),
//						rs.getString("floor"), rs.getString("village"), rs.getString("house_type"),
//						rs.getString("address"), rs.getString("subway"), rs.getString("p_time"), rs.getString("ori"),
//						rs.getString("bulid_time"), rs.getString("rent_type"), rs.getString("image"));
//				houseList.add(house);
//
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
//		return houseList;
//	}
//
//	@Override
//	public int countHouseByName(String name) {
//		super.conn = super.getConnection();
//		int count = 0;
//		String sql = "select * from houseinfo where name like concat('%',?,'%') ";
//		try {
//			super.pstm = conn.prepareStatement(sql);
//			pstm.setString(1, name);
//			super.rs = pstm.executeQuery();
//			while (rs.next()) {
//				count++;
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
//		return count;
//	}
//
//}
