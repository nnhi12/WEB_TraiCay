package Controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.SanPhamDAO;

@WebServlet("/DeleteSPController")
public class DeleteSPController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SanPhamDAO spDAO;
	
    public DeleteSPController() {
        super();
    }

	public void init() {
		spDAO = new SanPhamDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
	        String maSP = request.getParameter("maSP");
	        System.out.println(maSP);
			spDAO.deleteSP(maSP);					
			
            RequestDispatcher dispatcher = request.getRequestDispatcher("/QuanLySanPhamServlet");
            dispatcher.forward(request, response);
		} catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
