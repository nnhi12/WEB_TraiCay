package Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.TaiKhoanDAO;
import DAO.KhachHangDAO;
import Models.TAIKHOAN;
import Models.KHACHHANG;

@WebServlet("/khachhang/*")
public class KhachHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	KhachHangDAO khdao;
	TaiKhoanDAO tkdao;

    public KhachHangController() {
        super();

    }

	public void init(ServletConfig config) throws ServletException {
		khdao = new KhachHangDAO();
		tkdao = new TaiKhoanDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println("action error :"+ action );
		
		try {
			if (action.contains("/showlist")) {
				List<KHACHHANG> khs = khdao.layAllThongTinKhachHang();
				request.setAttribute("listKH", khs);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/QuanLyKhachHang.jsp");
				dispatcher.forward(request, response);
			}
			if(action.contains("/showinfo")) {
				String MaKH = request.getParameter("makh");
				KHACHHANG kh = khdao.layThongTinKhachHang(MaKH);
				String MaTK = kh.getMaTaiKhoan();
				TAIKHOAN tk = tkdao.layThongTinTaiKhoang(MaTK);
				request.setAttribute("khachhang", kh);
				request.setAttribute("taikhoan", tk);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ThongTinKhachHang.jsp");
				dispatcher.forward(request, response);
			}
			if(action.contains("/showinfokhachhang")) {
				String MaKH = request.getParameter("makh");
				KHACHHANG kh = khdao.layThongTinKhachHang(MaKH);
				String MaTK = kh.getMaTaiKhoan();
				TAIKHOAN tk = tkdao.layThongTinTaiKhoang(MaTK);
				request.setAttribute("khachhang", kh);
				request.setAttribute("taikhoan", tk);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/thongtincanhan.jsp");
				dispatcher.forward(request, response);
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
