package Controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ChiTietHoaDonDAO;
import DAO.GiaoVanDAO;
import DAO.HoaDonDAO;
import DAO.KhachHangDAO;
import DAO.SanPhamDAO;
import Models.CHITIETHOADON;
import Models.GIAMGIA;
import Models.GIAOVAN;
import Models.HOADON;
import Models.KHACHHANG;

/**
 * Servlet implementation class chitiethoadon
 */
@WebServlet("/chitiethoadon/*")
public class chitiethoadon extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ChiTietHoaDonDAO cthdDAO;
    private GiaoVanDAO gvDAO;
    private HoaDonDAO hdDAO;
    private KhachHangDAO khDAO;
    private SanPhamDAO spDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chitiethoadon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		cthdDAO = new ChiTietHoaDonDAO();
		 gvDAO= new GiaoVanDAO ();
		  hdDAO = new HoaDonDAO();
		 khDAO = new KhachHangDAO() ;
		 spDAO = new SanPhamDAO() ;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		try {
            switch (action) {    
                case "/listcthd":
                	listcthd(request, response);
                	break;
                case "/viewcthd":
                	showEditForm(request, response);
                	break;
                default:                   
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	 private void listcthd(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
			 HttpSession session = request.getSession();
			 String maKH = (String) session.getAttribute("maKH");
			KHACHHANG kh = khDAO.layThongTinKhachHang(maKH);
	        List<HOADON> listcthd = cthdDAO.selectallhoadon(maKH);
	        List<String> tts = gvDAO.layTTGiaoVan(maKH);
	        
	        request.setAttribute("khachhang",kh);
	        request.setAttribute("listcthd",listcthd);
	        request.setAttribute("giaovan",tts);
	        for (String cthd : tts) {
	        	System.out.println(cthd);
	        }
	        
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/Listhoadon.jsp");
	        System.out.println("nuuu");
	        System.out.println(request);
	        dispatcher.forward(request, response);
	    }
	 private void showEditForm(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		 		HttpSession session = request.getSession();
		        String MaHD = request.getParameter("mahd");
		        List<CHITIETHOADON> chitiets = cthdDAO.selectchitiet(MaHD);
		        String maKH = (String) session.getAttribute("maKH");
		        KHACHHANG kh = khDAO.layThongTinKhachHang(maKH);
		        String tinhtrang = gvDAO.layGiaoVanByMaHD(MaHD).getTinhTrang();
		        Date thoigiandat = hdDAO.layHoaDon(MaHD).getNgayDatHang();
		        List<String> tensps = new ArrayList<>();
		        List<String> donvis = new ArrayList<>();
		        for (CHITIETHOADON hd : chitiets) {
		        	String ma = hd.getMaSP();
		        	String ten = spDAO.layThongTinSP(ma).getTenSP();
		        	String donvi = spDAO.layThongTinSP(ma).getDonViTinh();
		        	tensps.add(ten);
		        	donvis.add(donvi);
		        }
		        
		        Float tongtien = hdDAO.layHoaDon(MaHD).getTongTien();
		        System.out.println(MaHD);
		        
		        request.setAttribute("khachhang",kh);
		        request.setAttribute("ten", tensps);
		        request.setAttribute("donvi", donvis);
		        request.setAttribute("chitiet",chitiets);
		        request.setAttribute("tinhtrang",tinhtrang);
		        request.setAttribute("thoigiandat",thoigiandat);
		        request.setAttribute("tongtien",tongtien);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/chitiethoadon.jsp");        
		        dispatcher.forward(request, response);
		        
		    }

}
