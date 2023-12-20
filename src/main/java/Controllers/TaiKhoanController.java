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

import DAO.KhachHangDAO;
import DAO.TaiKhoanDAO;
import Models.KHACHHANG;
import Models.TAIKHOAN;


@WebServlet("/taikhoan/*")
public class TaiKhoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TaiKhoanDAO taikhoanDAO;
    private KhachHangDAO khachhangDAO;

    public TaiKhoanController() {
        super();
    }

	public void init() {
        taikhoanDAO = new TaiKhoanDAO();
        khachhangDAO = new KhachHangDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action  = request.getPathInfo(); 
        try {
            if (action.equals("/ThemTaiKhoan")) {
                insertTK(request, response);}
            else if(action.equals("/Login")) {
            	login(request, response);
            }else{
                RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
    
    private void insertTK(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
    	
        request.setCharacterEncoding("UTF-8");
        String MaTK = taikhoanDAO.findNextMaTK();
        String MaKH = khachhangDAO.findNextMaKH();
        String TaiKhoan = request.getParameter("TaiKhoan");
        String MatKhau = request.getParameter("MatKhau");
        String HoTen = request.getParameter("HoTen");
        String GioiTinh = request.getParameter("GioiTinh");
        String DiaChi = request.getParameter("DiaChi");
        String SDT = request.getParameter("SDT");
        String NgaysinhString = request.getParameter("NgaySinh");        
        java.sql.Date NgaysinhDate = java.sql.Date.valueOf(NgaysinhString);
        
        taikhoanDAO.CreateNewTK(MaTK, TaiKhoan, MatKhau);        
        KHACHHANG insertKH = new KHACHHANG(MaKH, HoTen, GioiTinh, NgaysinhDate, DiaChi, SDT, MaTK);
        khachhangDAO.CreateNewKH(insertKH);
        response.sendRedirect(request.getContextPath() + "/Login.jsp");
    }
    
    private void login(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
    	request.setCharacterEncoding("UTF-8");
    	String TenDangNhap = request.getParameter("TaiKhoan");
        String Password = request.getParameter("MatKhau");
        TAIKHOAN taikhoan = new TAIKHOAN();
        taikhoan.setTaiKhoan(TenDangNhap);
        taikhoan.setMatKhau(Password);
        String matk = taikhoanDAO.LOGIN(TenDangNhap, Password);
        if(matk != null)
        {
            taikhoan = taikhoanDAO.selectTaiKhoanByMaTK(matk);
            HttpSession session = request.getSession();
            session.setAttribute("matk", matk);
            if(taikhoan.getPhanQuyen().equals("KhachHang"))
            {                
                response.sendRedirect(request.getContextPath() + "/Sanpham/ListSP");
            }
            else if (taikhoan.getPhanQuyen().equals("Admin")) {
                response.sendRedirect(request.getContextPath() + "/ThongBao/list_ThongBaoGiangVienController"); }
        }
        else {
            request.setAttribute("errMsg", "Thông tin đăng nhập không chính xác!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.jsp");
            try{
                dispatcher.forward(request, response);
            }catch (ServletException e) {
                e.printStackTrace();
            }
        }
    }
    
}
