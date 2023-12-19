package Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.SanPhamDAO;
import Models.SANPHAM;


@WebServlet("/TrangChuAdminController")
public class TrangChuAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SanPhamDAO spDAO;   

    public TrangChuAdminController() {
        super();  
    }


	public void init()  {
		spDAO = new SanPhamDAO();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List <SANPHAM> listSP = spDAO.selectSP();
            RequestDispatcher dispatcher = request.getRequestDispatcher("/TrangChuAdmin.jsp");
        	request.setAttribute("listSP", listSP);
        	dispatcher.forward(request, response);        	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
