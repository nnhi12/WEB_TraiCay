package Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.GiamGiaDAO;
import DAO.LoaiSPDAO;
import DAO.NhaCungCapDAO;
import DAO.SanPhamDAO;
import Models.GIAMGIA;
import Models.LOAISP;
import Models.NHACUNGCAP;
import Models.SANPHAM;

@WebServlet("/ChiTietSPAdminController")
public class ChiTietSPAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SanPhamDAO spDAO;   
	private GiamGiaDAO ggDAO;
    private NhaCungCapDAO nccDAO;
    private LoaiSPDAO lspDAO;
	
    public ChiTietSPAdminController() {
        super();

    }


	public void init() {
		spDAO = new SanPhamDAO();
		ggDAO = new GiamGiaDAO();
		nccDAO = new NhaCungCapDAO();
		lspDAO = new LoaiSPDAO();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
	        String maSP = request.getParameter("maSP");
			SANPHAM sanpham = spDAO.layThongTinSP(maSP);
			byte[] hinhAnh = spDAO.layDuLieuAnh(maSP);
			String base64Image = Base64.getEncoder().encodeToString(hinhAnh);
			
			
			List<GIAMGIA> listGG = ggDAO.selectallgiamgia();
			List <NHACUNGCAP> listNCC = nccDAO.selectNCC();
			List <LOAISP> listLSP = lspDAO.selectLSP();

            RequestDispatcher dispatcher = request.getRequestDispatcher("/EditSP.jsp");
            request.setAttribute("listGG", listGG);
	    	request.setAttribute("listNCC", listNCC);
	    	request.setAttribute("listLSP", listLSP);
    		request.setAttribute("sanpham", sanpham);
    		request.setAttribute("maSP", maSP);
    		request.setAttribute("base64Image", base64Image);
            dispatcher.forward(request, response);
		} catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
