package Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.GiaoVanDAO;
import DAO.GioHangDAO;
import DAO.HoaDonDAO;
import DAO.KhachHangDAO;
import DAO.SanPhamDAO;
import DAO.ChiTietHoaDonDAO;
import Models.CHITIETHOADON;
import Models.GIAOVAN;
import Models.GIOHANG;
import Models.HOADON;
import Models.KHACHHANG;
import Models.SANPHAM;

@WebServlet("/dathang/*")
public class DatHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GiaoVanDAO gvDAO;
	private GioHangDAO ghDAO;
	private SanPhamDAO spDAO;
	private KhachHangDAO khDAO;
	private HoaDonDAO hdDAO;
	private ChiTietHoaDonDAO cthdDAO;
	
    public DatHangController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		ghDAO = new GioHangDAO();
		spDAO = new SanPhamDAO();
		khDAO = new KhachHangDAO();
		hdDAO = new HoaDonDAO();
		cthdDAO = new ChiTietHoaDonDAO();
		gvDAO = new GiaoVanDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String maKH = (String) session.getAttribute("maKH");
		
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
			        List<Float> giaGiam = new ArrayList<>();
			        
			        KHACHHANG kh = khDAO.layThongTinKhachHang(maKH);
			        float tongtien = hdDAO.TongTienHD(maKH);
			        for (GIOHANG gioHang : listGH) {
			            String masp = gioHang.getMaSP();
			            Float giagiam = spDAO.GiaSauGiam(masp);
			            byte[] hinhAnh = spDAO.layDuLieuAnh(masp);
			            String base64Image = Base64.getEncoder().encodeToString(hinhAnh);
			            maSP.add(masp);
			            dsAnh.add(base64Image);
			            giaGiam.add(giagiam);
			        }
			        request.setAttribute("listGH", listGH);
			        request.setAttribute("listTen", listTen);
			        request.setAttribute("listGia", listGia);
            		request.setAttribute("base64Image", dsAnh);
			        request.setAttribute("khachhang", kh);	
			        request.setAttribute("giagiam", giaGiam);
			        request.setAttribute("tongtien", tongtien);
			        RequestDispatcher dispatcher = request.getRequestDispatcher("/DatHang.jsp");
			        dispatcher.forward(request, response);
        		}
            	if (action.equals("/insert"))
        		{
            		String mahd = hdDAO.findNextMaHD();
            		float tongtien = Float.parseFloat(request.getParameter("tongTien"));
            		String pttt = request.getParameter("paymentMethod");
            		LocalDate currdate = LocalDate.now();
            		Date ngaydat = Date.valueOf(currdate);
            		HOADON hd = new HOADON(mahd, maKH, tongtien, null, pttt, ngaydat, false);
            		hdDAO.insertSP(hd);
            		List <GIOHANG> listGH = ghDAO.layGH(maKH);
            		for(GIOHANG hang: listGH) {
            			SANPHAM sp = spDAO.layThongTinSP(hang.getMaSP());
            			float gia = sp.getGia() * hang.getSoLuong();
            			CHITIETHOADON cthd = new CHITIETHOADON(mahd, hang.getMaSP(), hang.getSoLuong(), gia);
            			cthdDAO.insertCTHD(cthd);
            		}
            		spDAO.updateSLSP(maKH);
            		ghDAO.deleteAllGH(maKH);
            		String magv = gvDAO.findNextMaGV();
            		gvDAO.insertGV(new GIAOVAN(magv, mahd, "CB"));
            		
	                RequestDispatcher dispatcher = request.getRequestDispatcher(request.getContextPath() + "/taikhoan/Login");   
            		dispatcher.forward(request, response);
        		}
        		
            } catch (SQLException e) {
                e.printStackTrace();
            }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
