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

import DAO.SanPhamDAO;
import Models.SANPHAM;

@WebServlet("/chitietsp")
public class ChiTietSPController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SanPhamDAO spDAO;
    public ChiTietSPController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		spDAO = new SanPhamDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        String action = request.getPathInfo();
		System.out.println("action error :"+ action );
		try {
			String maSP = "SP001";
			SANPHAM sp = spDAO.layThongTinSP(maSP);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ChiTietSP.jsp");
    		request.setAttribute("sanpham", sp);
    		System.out.println(sp.getTenSP());
            dispatcher.forward(request, response);
		} catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
