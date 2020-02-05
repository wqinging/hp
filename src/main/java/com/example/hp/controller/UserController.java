//package com.example.hp.controller;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//import java.util.Random;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.RestTest;
//
//import domian.PubHouse;
//import domian.User;
//import service.UserService;
//import serviceImpl.UserServiceImpl;
//
//public class UserController extends HttpServlet {
//
//	private static final long serialVersionUID = 1L;
//
//	UserService userService = new UserServiceImpl();
//
//	@Override
//	protected void service(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String flag = request.getParameter("flag");
//		if (flag.equals("login")) {
//			String vNum = request.getParameter("validNum");
//			String pars = (String) request.getSession().getAttribute("params");
//			if(vNum.equals(pars)){
//				String pNumber = request.getParameter("phoneNumber");
//				User user = new User();
//				user.setPhoneNumber(pNumber);
//				User u = userService.checkUser(user);
//				if(u.getPhoneNumber()==null) {
//					u.setPhoneNumber(pNumber);
//					userService.registerUser(u);
//				}
//				request.getSession().setAttribute("user", u);
//				response.sendRedirect("houseServlet.do");
//			}else {
//				request.setAttribute("error", "验证码错误,请重新输入");
//				request.getRequestDispatcher("/views/logreg.jsp").forward(request,response);
//			}
//		}else if (flag.equals("addPublicHouse")) {
//			String area = request.getParameter("area");
//			String build = request.getParameter("build");
//			String unit = request.getParameter("unit");
//			String signum = request.getParameter("signum");
//			String price = request.getParameter("price");
//			User u = (User) request.getSession().getAttribute("user");
//			String userPhone = u.getPhoneNumber();
//			PubHouse pubHouse = new PubHouse(userPhone,area, build, unit, signum, price);
//			pubHouse.setCity("南京");
//			userService.insertPHouse(pubHouse);
//			response.sendRedirect("userServlet.do?flag=showPHouse");
//
//		} else if (flag.equals("publicHouse")) {
//			User user = (User) request.getSession().getAttribute("user");
//			if (user != null) {
//				request.getRequestDispatcher("/views/pubHouse.jsp").forward(request, response);
//			} else {
//				request.getRequestDispatcher("/views/logreg.jsp").forward(request, response);
//			}
//		}else if(flag.equals("validUser")) {
//			request.getSession().removeAttribute("user");
//			response.sendRedirect("houseServlet.do");
//		}else if(flag.equals("getValidNum")) {
//			String params = "";
//			String mobile = request.getParameter("phoneNumber");
//			String sid = "71657f6085ee3f563f94514b17234283";
//			String token = "cc58bcc7ec5da05bbd9b2c8eaa841e66";
//			String appid = "e4459e09a60b48bf922ad94ee9577585";
//			String templateid = "321703";
//			String uid = "";
//			Random random = new Random();
//			int name = random.nextInt(10000);
//			while(true){
//				if(name>999){
//					params = String.valueOf(name);
//					break;
//				}
//			}
//			request.getSession().setAttribute("params", params);
//			RestTest.testSendSms(sid, token, appid, templateid, params, mobile, uid);
//
//		}else if(flag.equals("showPHouse")) {
//			User u = (User) request.getSession().getAttribute("user");
//			String p = u.getPhoneNumber();
//			List<PubHouse> list = userService.findPHouse(p);
//			request.setAttribute("list", list);
//			request.getRequestDispatcher("/views/showPHouse.jsp").forward(request, response);
//		}else if(flag.equals("deleteph")) {
//			User u = (User) request.getSession().getAttribute("user");
//			int id = Integer.parseInt(request.getParameter("id"));
//			userService.deletePHouse(id);
//			response.sendRedirect("userServlet.do?flag=showPHouse");
//		}else if(flag.equals("dochangUser")) {
//			String name = request.getParameter("name");
//			String password = request.getParameter("password");
//			User u = (User) request.getSession().getAttribute("user");
//			u.setName(name);
//			u.setPassword(password);
//			userService.updateUser(u);
//			response.sendRedirect("houseServlet.do");
//		}else if(flag.equals("loginByPassword")) {
//			String pNumber = request.getParameter("phoneNumber");
//			String password = request.getParameter("password");
//			User user = new User();
//			user.setPhoneNumber(pNumber);
//			user.setPassword(password);
//			User u = userService.checkUserByPassword(user);
//			if(u.getPhoneNumber()==null) {
//				request.setAttribute("perror", "用户名不存在或者密码错误");
//				request.getRequestDispatcher("/views/logreg.jsp").forward(request,response);
//			}else {
//				request.getSession().setAttribute("user", u);
//				response.sendRedirect("houseServlet.do");
//			}
//		}
//
//
//	}
//
//}
