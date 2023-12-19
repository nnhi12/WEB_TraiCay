package Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.GiaoVanDAO;
import DAO.KhachHangDAO;
import DAO.HoaDonDAO;
import DAO.SanPhamDAO;

import Models.GIAOVAN;
import Models.KHACHHANG;
import Models.HOADON;
import Models.CHITIETHOADON;
import Models.SANPHAM;

@WebServlet("/giaovan/*")
public class GiaoVanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GiaoVanDAO gvdao;
	private KhachHangDAO khdao;
	private HoaDonDAO hddao;
	private SanPhamDAO spdao;

    public GiaoVanController() {
        super();

    }

	public void init(ServletConfig config) throws ServletException {
		gvdao = new GiaoVanDAO();
		khdao = new KhachHangDAO();
		hddao = new HoaDonDAO();
		spdao = new SanPhamDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println("action error :"+ action );
		
		try {
			if (action.contains("/showlist")) {
				List<GIAOVAN> gvs = gvdao.layAllGiaoVan();
				request.setAttribute("listGV", gvs);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/QuanLyGiaoVan.jsp");
				dispatcher.forward(request, response);
			}
			if(action.contains("/showinfo")) {
				String MaGV = request.getParameter("magv");
				String MaHD = request.getParameter("mahd");
				GIAOVAN gv = gvdao.layGiaoVan(MaGV);
				HOADON hd = hddao.layHoaDon(MaHD);
				KHACHHANG kh = khdao.layThongTinKhachHang(hd.getMaKH());
				List<CHITIETHOADON> chitiets = hddao.layChiTiet(MaHD);
				List<SANPHAM> sps = new ArrayList<>();
				for(CHITIETHOADON chitiet: chitiets) {
					SANPHAM sp = spdao.layThongTinSP(chitiet.getMaSP());
					sps.add(sp);
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ThongTinDonHang.jsp");
				request.setAttribute("giaovan", gv);
				request.setAttribute("hoadon", hd);
				request.setAttribute("khachhang", kh);
				request.setAttribute("chitiethoadon", chitiets);
				request.setAttribute("listSP", sps);
				dispatcher.forward(request, response);
			}
			if(action.contains("/update")) {
				String MaGV = request.getParameter("magv");
				String tinhtrang = request.getParameter("tinhtrang");
				if(tinhtrang.equals("DT")) {
					if(gvdao.updateNgayNhan(MaGV, tinhtrang)) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("/giaovan/showlist");
						dispatcher.forward(request, response);
					}
				}
				else {
					if(gvdao.updateTinhTrang(MaGV, tinhtrang)) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("/giaovan/showlist");
						dispatcher.forward(request, response);
					}
				}
			}
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
