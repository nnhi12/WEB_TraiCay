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

import DAO.ChiTietHoaDonDAO;
import DAO.GiaoVanDAO;
import DAO.HoaDonDAO;
import DAO.KhachHangDAO;
import DAO.SanPhamDAO;
import Models.CHITIETHOADON;
import Models.GIAMGIA;

/**
 * Servlet implementation class chitiethoadon
 */
@WebServlet("/chitiethoadon/*")
public class chitiethoadon extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ChiTietHoaDonDAO cthdDAO;
    private GiaoVanDAO gvDAO;
    private HoaDonDAO hdDAO;
    private KhachHangDAO khDAO;
    private SanPhamDAO spDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chitiethoadon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		cthdDAO = new ChiTietHoaDonDAO();
		 gvDAO= new GiaoVanDAO ();
		  hdDAO = new HoaDonDAO();
		 khDAO = new KhachHangDAO() ;
		 spDAO = new SanPhamDAO() ;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		try {
            switch (action) {    
                case "/listcthd":
                	listcthd(request, response);
                	break;
                case "/viewcthd":
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
	 private void listcthd(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
	        //HttpSession session = request.getSession();
	        List<CHITIETHOADON> listcthd = cthdDAO.selectallhoadon();
	        request.setAttribute("listcthd",listcthd );
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/Listhoadon.jsp");
	        System.out.println("nuuu");
	        System.out.println(request);
	        dispatcher.forward(request, response);
	    }
	 private void showEditForm(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		        String MaHD = request.getParameter("mahd");
		        CHITIETHOADON GG = cthdDAO.selectchitiet(MaHD);
		        System.out.println(MaHD);
		        
		        request.setAttribute("chitiet", GG);		      
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/chitiethoadon.jsp");        
		        dispatcher.forward(request, response);
		        
		    }

}
