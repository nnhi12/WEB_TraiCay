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

import DAO.GiamGiaDAO;
import DAO.LoaiSPDAO;
import DAO.NhaCungCapDAO;
import Models.GIAMGIA;
import Models.LOAISP;
import Models.NHACUNGCAP;


@WebServlet("/LoadDataInsertController")
public class LoadDataInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GiamGiaDAO ggDAO;
    private NhaCungCapDAO nccDAO;
    private LoaiSPDAO lspDAO;   

    public LoadDataInsertController() {
        super();
    }


	public void init() {
		ggDAO = new GiamGiaDAO();
		nccDAO = new NhaCungCapDAO();
		lspDAO = new LoaiSPDAO();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<GIAMGIA> listGG;
		try {
			listGG = ggDAO.selectGG();
			List <NHACUNGCAP> listNCC = nccDAO.selectNCC();
			List <LOAISP> listLSP = lspDAO.selectLSP();
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/InsertSP.jsp");
	        request.setAttribute("listGG", listGG);
	    	request.setAttribute("listNCC", listNCC);
	    	request.setAttribute("listLSP", listLSP);
	    	dispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
