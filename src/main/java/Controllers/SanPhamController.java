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

@WebServlet("/Sanpham/*")
public class SanPhamController  extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SanPhamDAO sanphamDAO;

    public void init() {
        sanphamDAO = new SanPhamDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action  = request.getPathInfo(); // cách lấy đường dẫn con trong trường hợp servlet chia nhánh
        try {
            if (action.equals("/ListSP")) {
                ListSP(request, response);}
            else
            {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    
    
    private void ListSP(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
    	
    	HttpSession session = request.getSession();
        List<SANPHAM> listSP = sanphamDAO.getAllSP();
        request.setAttribute("listSP", listSP);        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/TrangChu.jsp");
        dispatcher.forward(request, response);
    }
}
