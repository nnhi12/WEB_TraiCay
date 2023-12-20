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

import DAO.KhachHangDAO;
import Models.GIAMGIA;
import Models.KHACHHANG;

/**
 * Servlet implementation class ThongTinKhachHangController
 */
@WebServlet("/thongtinkhachhang/*")
public class ThongTinKhachHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      KhachHangDAO khDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThongTinKhachHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		khDAO = new KhachHangDAO();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		try {
            switch (action) {
                case "/profile":
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
	 private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, ServletException, IOException {
					HttpSession session = request.getSession();
					String maKH = (String) session.getAttribute("maKH");	 	
			        KHACHHANG GG = khDAO.layThongTinKhachHang(maKH);			      
			        request.setAttribute("khachhang", GG);		      
			        RequestDispatcher dispatcher = request.getRequestDispatcher("/thongtincanhan.jsp");        
			        dispatcher.forward(request, response);
			        
			    }
}
