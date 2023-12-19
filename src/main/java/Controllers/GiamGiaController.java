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
                case "/newgg":
                	showNewForm(request, response);
                    break;
                case "/insertgg":
                	insertgiamgia(request, response);
                    break;
                case "/editgg":
                	showEditForm(request, response);
                    break;
                case "/updategg":
                	updategiamgia(request, response);
                    break;
                case "/deletegg":
                	deletegiamgia(request, response);
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
		List<GIAMGIA> gg = giamgiaDAO.selectallgiamgia();
		request.setAttribute("listgiamgia", gg);
		RequestDispatcher dis = request.getRequestDispatcher("/giamgia.jsp");	
		dis.forward(request, response);		
	}
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/ThemGG.jsp");
		        dispatcher.forward(request, response);
		    }
	 private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, ServletException, IOException {
			        String MaGG = request.getParameter("magiamgia");
			        GIAMGIA GG = giamgiaDAO.selectGiamgia(MaGG); 
			        System.out.println(MaGG);
			        System.out.println(GG);
			        request.setAttribute("giamgia", GG);		      
			        RequestDispatcher dispatcher = request.getRequestDispatcher("/EditGG.jsp");        
			        dispatcher.forward(request, response);
			        
			    }
	 private void updategiamgia(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		 
		 String MaGG = request.getParameter("magiamgia");
		
		String PhanTram =request.getParameter("phantram");
		int PhanTramgg =0;
		if (PhanTram != null && !PhanTram.isEmpty()) {
			PhanTramgg = Integer.parseInt(PhanTram);
		}
		String NgayHetHan = request.getParameter("ngayhethan");
		LocalDate ngayhethan = null;

		if (NgayHetHan != null && !NgayHetHan.isEmpty()) {
			ngayhethan = LocalDate.parse(NgayHetHan);
		}
        GIAMGIA updateGG = new GIAMGIA(MaGG,PhanTramgg,ngayhethan);
        giamgiaDAO.updateGiamgia(updateGG);
        response.sendRedirect("listgg");
	    }

	private void insertgiamgia(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		try {
		request.setCharacterEncoding("UTF-8");
		String MaGG = request.getParameter("magiamgia");
		 System.out.println(MaGG);
		String PhanTram =request.getParameter("phantram");
		int PhanTramgg =0;
		if (PhanTram != null && !PhanTram.isEmpty()) {
			PhanTramgg = Integer.parseInt(PhanTram);
		}
		String NgayHetHan = request.getParameter("ngayhethan");
		LocalDate ngayhethan = null;

		if (NgayHetHan != null && !NgayHetHan.isEmpty()) {
			ngayhethan = LocalDate.parse(NgayHetHan);
		}
		GIAMGIA newgiamgia = new GIAMGIA(MaGG,PhanTramgg,ngayhethan);
		giamgiaDAO.insertGiamgia(newgiamgia);
		response.sendRedirect("listgg");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void deletegiamgia(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String MaGG =request.getParameter("magiamgia");
        giamgiaDAO.deleteGiamgia(MaGG);
        response.sendRedirect("listgg");
    }
	
}
