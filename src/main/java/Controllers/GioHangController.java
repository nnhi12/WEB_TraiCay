package Controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.GioHangDAO;
import Models.GIOHANG;

@WebServlet("/giohang/*")
public class GioHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GioHangDAO ghDAO;
	
    public GioHangController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		ghDAO = new GioHangDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        //String IDDangNhap = (String) session.getAttribute("IDDangNhap");
        String action = request.getPathInfo();
		System.out.println("action error :"+ action );
   
        //if (IDDangNhap != null) {
        	request.setCharacterEncoding("UTF-8");
            try {
            	if (action.equals("/insert"))
        		{
	        		String maSP = "SP001";
	                String maKH = "KH001";
	                String soluongStr = request.getParameter("soluong");
	                System.out.println(soluongStr);
	                int soLuong = 0;
	                if (soluongStr != null && !soluongStr.isEmpty()) {
	                    soLuong = Integer.parseInt(soluongStr);
	                }
	                GIOHANG gh = new GIOHANG(maSP, maKH, soLuong);
	
	                ghDAO.insertGH(gh);
	                
	                RequestDispatcher dispatcher = request.getRequestDispatcher("/chitietsp");
            		request.setAttribute("giohang", gh);
            		dispatcher.forward(request, response);
        		}
        		if (action.equals("/update"))
        		{
        			String maSP = "SP001";
	                String maKH = "KH001";
	
	                String soluongParam = request.getParameter("soluong");
	                System.out.println(soluongParam);
	                int soLuong;

	                if (soluongParam != null && !soluongParam.isEmpty()) {
	                    soLuong = Integer.parseInt(soluongParam);
	                } else {
	                    soLuong = 1; // Giá trị mặc định là 1
	                }
	
	                GIOHANG gh = new GIOHANG(maSP, maKH, soLuong);
	
	                ghDAO.updateGH(gh);
	                
                	RequestDispatcher dispatcher = request.getRequestDispatcher("GioHang.jsp");
            		request.setAttribute("giohang", gh);
            		dispatcher.forward(request, response);
        		}
            } catch (SQLException e) {
                e.printStackTrace();
            }
        //} else {
            //response.sendRedirect("/login.jsp");
        //}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
