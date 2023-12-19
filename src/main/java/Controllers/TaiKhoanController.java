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

/**
 * Servlet implementation class TaiKhoanController
 */
@WebServlet("/taikhoan")
public class TaiKhoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TaiKhoanDAO taikhoanDAO;
    private KhachHangDAO khachhangDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaiKhoanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	public void init() {
        taikhoanDAO = new TaiKhoanDAO();
        khachhangDAO = new KhachHangDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action  = request.getPathInfo(); // cách lấy đường dẫn con trong trường hợp servlet chia nhánh
        try {
            if (action.equals("/ThemTaiKhoan")) {
                insertSinhvien(request, response);}
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public String MaTK() {
	    String accountCode = "TK";

	    // Sử dụng phương pháp tạo số ngẫu nhiên, ví dụ: Math.random()
	    int randomCode = (int)(Math.random() * 900) + 100;

	    // Kết hợp phần số ngẫu nhiên vào mã tài khoản
	    accountCode += randomCode;

	    // Trả về mã tài khoản
	    return accountCode;
	}
    public String MaKH() {
	    String accountCode = "KH";

	    // Sử dụng phương pháp tạo số ngẫu nhiên, ví dụ: Math.random()
	    int randomCode = (int)(Math.random() * 900) + 100;

	    // Kết hợp phần số ngẫu nhiên vào mã tài khoản
	    accountCode += randomCode;

	    // Trả về mã tài khoản
	    return accountCode;
	}
    
    private void insertSinhvien(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
    	
        request.setCharacterEncoding("UTF-8");
        String MaTK = MaTK();
        String MaKH = MaKH();
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
            request.setAttribute("errMsg", "Thông tin đăng nhập không chính xác");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.jsp");
            try{
                dispatcher.forward(request, response);
            }catch (ServletException e) {
                e.printStackTrace();
            }
        }
    }

}
