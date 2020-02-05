//package com.example.hp.serviceImpl;
//
//import java.util.List;
//
//import com.example.hp.dao.HouseDao;
//import com.example.hp.domian.House;
//import com.example.hp.domian.Page;
//import com.example.hp.service.HouseService;
//public class HouseServiceImpl implements HouseService {
//
//	private HouseDao houseDao= new HouseDaoImpl();
//
//	@Override
//	public List<House> showHouse(String regiArg, String subArg, String rentArg, String areaArg, String typeArg, Page page) {
//		return houseDao.findHouse(regiArg,subArg,rentArg,areaArg,typeArg,page);
//	}
//
//	@Override
//	public int countHouse(String regiArg, String subArg, String rentArg, String areaArg, String typeArg) {
//		return houseDao.countHouse(regiArg,subArg,rentArg,areaArg,typeArg);
//	}
//
//	@Override
//	public House showHouseByName(String name) {
//		// TODO Auto-generated method stub
//		return houseDao.showHouseByName(name);
//	}
//
//	@Override
//	public List<House> searchHouseByName(String name) {
//		// TODO Auto-generated method stub
//		return houseDao.searchHouseByName(name);
//	}
//
//	@Override
//	public int countHouseByName(String name) {
//		// TODO Auto-generated method stub
//		return houseDao.countHouseByName(name);
//	}
//
//}
