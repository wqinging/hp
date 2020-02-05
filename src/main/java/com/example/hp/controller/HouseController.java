//package com.example.hp.controller;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//
//import com.example.hp.domian.House;
//import com.example.hp.domian.Page;
//import com.example.hp.service.HouseService;
//import com.example.hp.serviceImpl.HouseServiceImpl;
//
//public class HouseController extends HttpServlet {
//
//	private HouseService houseService= new HouseServiceImpl();
//
//	private static final long serialVersionUID = 1L;
//
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String flag = req.getParameter("flag");
//		if (flag == null) {
//			req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
//		}else if(flag.equals("query")){
//			String currentPage =req.getParameter("currentPage");
//			String regiArg = req.getParameter("regiArg");
//            String subArg  = req.getParameter("subArg");
//			String rentArg = req.getParameter("rentArg");
//			String areaArg = req.getParameter("areaArg");
//			String typeArg = req.getParameter("typeArg");
//			int curpage = 1;
//			if(currentPage !=null) {
//				curpage=Integer.parseInt(currentPage);
//			}
//			PrintWriter out = resp.getWriter();
//			int totalAmount = houseService.countHouse(regiArg,subArg,rentArg,areaArg,typeArg);
//            Page page = new Page(totalAmount,8,curpage);
//            List<House> houseList = houseService.showHouse(regiArg,subArg,rentArg,areaArg,typeArg,page);
//            JSONObject houseData = new JSONObject();
//			houseData.put("houseData", houseList);
//			houseData.put("totalAmount", totalAmount);
//			houseData.put("flag", flag);
//			houseData.put("regiArg", regiArg);
//			houseData.put("rentArg", rentArg);
//			houseData.put("areaArg", areaArg);
//			houseData.put("subArg", subArg);
//			houseData.put("typeArg", typeArg);
//			houseData.put("currentPage", curpage);
//			out.print(houseData);
//			out.flush();
//			out.close();
//		}else if(flag.equals("queryDetails")) {
//			String name = req.getParameter("name");
//			House house = houseService.showHouseByName(name);
//			req.setAttribute("houseDemo", house);
//			req.getRequestDispatcher("views/infoDetails.jsp").forward(req, resp);
//		}else if(flag.equals("queryByName")) {
//			PrintWriter out = resp.getWriter();
//			String houseName = req.getParameter("name");
//			List<House> list = houseService.searchHouseByName(houseName);
//			int totalAmount = houseService.countHouseByName(houseName);
//			JSONObject houseData = new JSONObject();
//			houseData.put("houseData", list);
//			houseData.put("totalAmount", totalAmount);
//			out.print(houseData);
//			out.flush();
//			out.close();
//		}
//	}
//
//}
