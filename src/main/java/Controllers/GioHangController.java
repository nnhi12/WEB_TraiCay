package Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.GioHangDAO;
import DAO.SanPhamDAO;
import Models.GIOHANG;

@WebServlet("/giohang/*")
public class GioHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GioHangDAO ghDAO;
	private SanPhamDAO spDAO;
	
    public GioHangController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		ghDAO = new GioHangDAO();
		spDAO = new SanPhamDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String maKH = (String) session.getAttribute("maKH");	
        //String IDDangNhap = (String) session.getAttribute("IDDangNhap");
        String action = request.getPathInfo();
		System.out.println("action error :"+ action );
   
        //if (IDDangNhap != null) {
        	request.setCharacterEncoding("UTF-8");
            try {
            	if (action.equals("/load"))
        		{
			        List <GIOHANG> listGH = ghDAO.layGH(maKH);
			        List <String> listTen = ghDAO.layTenSP_TheoKH(maKH);
			        List <Float> listGia = ghDAO.layGiaSP_TheoKH(maKH);
			        List<String> maSP = new ArrayList<>();
			        List<String> dsAnh = new ArrayList<>();
			        
			        for (GIOHANG gioHang : listGH) {
			            String masp = gioHang.getMaSP();
			            byte[] hinhAnh = spDAO.layDuLieuAnh(masp);
			            String base64Image = Base64.getEncoder().encodeToString(hinhAnh);
			            maSP.add(masp);
			            dsAnh.add(base64Image);
			        }
			        request.setAttribute("listGH", listGH);
			        request.setAttribute("listTen", listTen);
			        request.setAttribute("listGia", listGia);
            		request.setAttribute("base64Image", dsAnh);
			        RequestDispatcher dispatcher = request.getRequestDispatcher("/GioHang.jsp");
			        dispatcher.forward(request, response);
        		}
            	if (action.equals("/insert"))
        		{
            		String maSP = request.getParameter("maSP");
	                String soluongStr = request.getParameter("soluong");
	                System.out.println(soluongStr);
	                int soLuong = 0;
	                if (soluongStr != null && !soluongStr.isEmpty()) {
	                    soLuong = Integer.parseInt(soluongStr);
	                }
	                GIOHANG gh = new GIOHANG(maSP, maKH, soLuong);
	
	                ghDAO.insertGH(gh);
	                
	                RequestDispatcher dispatcher = request.getRequestDispatcher("/giohang/load");
	               
            		request.setAttribute("giohang", gh);
            		dispatcher.forward(request, response);
        		}
        		if (action.equals("/update"))
        		{
        			 String maSP = request.getParameter("masp");
	
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
	                
	                response.sendRedirect(request.getContextPath()+"/giohang/load");
        		}
        		
        		if (action.equals("/delete"))
        		{
	                String maSP = request.getParameter("masp");
	                
	                GIOHANG gh = new GIOHANG();
	                gh.setMaKH(maKH);
	                gh.setMaSP(maSP);
	                
	                ghDAO.deleteGH(gh);
	                
	                response.sendRedirect(request.getContextPath()+"/giohang/load");
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
