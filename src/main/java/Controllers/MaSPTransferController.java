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
import javax.servlet.http.HttpSession;

import DAO.GioHangDAO;
import DAO.SanPhamDAO;
import Models.GIOHANG;
import Models.SANPHAM;


@WebServlet("/masptransfer")
public class MaSPTransferController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SanPhamDAO spDAO;
    private GioHangDAO ghDAO;
    
    public MaSPTransferController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		spDAO = new SanPhamDAO();
		ghDAO = new GioHangDAO();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maSP = request.getParameter("masp");
		HttpSession session = request.getSession();
		session.setAttribute("MaSP", maSP);
		
		String action = request.getPathInfo();
		System.out.println("action error :"+ action );
		
		request.setCharacterEncoding("UTF-8");
        try {

			SANPHAM sp = spDAO.layThongTinSP(maSP);
			//System.out.println(dt);
			String MaKH = "KH001";
			//System.out.println(MaDK);
			List<GIOHANG> ghs = ghDAO.layGH(MaKH);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/DatHang.jsp");
			dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

}
