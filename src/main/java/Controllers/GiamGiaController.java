package Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.GiamGiaDAO;
import Models.GIAMGIA;

/**
 * Servlet implementation class GiamGiaController
 */
@WebServlet("/giamgia/*")
public class GiamGiaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private GiamGiaDAO giamgiaDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GiamGiaController() {
       this.giamgiaDAO = new GiamGiaDAO();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		giamgiaDAO = new GiamGiaDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getPathInfo();
		try {
            switch (action) {
                case "/listgg":
                	listgiamgia(request, response);
                    break;
                case "/insertgg":
                	insertgiamgia(request, response);
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
	private void listgiamgia(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
	{
		List<GIAMGIA> SinhVien = giamgiaDAO.selectallgiamgia();
		request.setAttribute("listgiamgia", SinhVien);
		RequestDispatcher dis = request.getRequestDispatcher("/giamgia.jsp");	
		dis.forward(request, response);		
	}
	private void insertgiamgia(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String MaGG = request.getParameter("magiamgia");
		int PhanTram =Integer.parseInt(request.getParameter("phamtram"));
		LocalDate NgayHetHan = LocalDate.parse(request.getParameter("ngayhethan"));
		GIAMGIA newgiamgia = new GIAMGIA(MaGG,PhanTram,NgayHetHan);
		giamgiaDAO.insertGiamgia(newgiamgia);
		response.sendRedirect("listgg");
	}
}
