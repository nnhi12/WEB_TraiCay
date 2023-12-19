package Controllers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DAO.SanPhamDAO;
import Models.SANPHAM;
import Util.HandleException;


@WebServlet("/InsertSPController")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, 
					maxFileSize = 1024 * 1024 * 50,      
					maxRequestSize = 1024 * 1024 * 100)
public class InsertSPController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SanPhamDAO spDAO;
    
	
	
    public InsertSPController() {
        super();
    }


	public void init() {
		spDAO = new SanPhamDAO();
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			insertSP(request, response);  
		} catch (SQLException ex) {
		    throw new ServletException(ex);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/InsertSP.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void insertSP(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		
		String MaSP = spDAO.findNextMaSP();
        String TenSP = request.getParameter("TenSP");
        String MaLoaiSP = request.getParameter("MaLoaiSP");
        String soLuongStr = request.getParameter("SoLuong");
        int SoLuong = 0; 
        if (soLuongStr != null && !soLuongStr.isEmpty()) {
            SoLuong = Integer.parseInt(soLuongStr);
        }
        String DonViTinh = request.getParameter("DonViTinh");      
        String giaStr = request.getParameter("Gia");
        float Gia = 0.0f; 
        if (giaStr != null && !giaStr.isEmpty()) {
            Gia = Float.parseFloat(giaStr);
        }
        Part hinhAnhPart = request.getPart("hinhAnh");

        InputStream hinhAnhStream = hinhAnhPart.getInputStream();
        byte[] HinhAnh = hinhAnhStream.readAllBytes();
        String MaGG = request.getParameter("MaGG");
        String MaNCC = request.getParameter("MaNCC");

    	SANPHAM sp = new SANPHAM(MaSP, TenSP, MaLoaiSP, SoLuong, DonViTinh, Gia, HinhAnh, MaGG, MaNCC);

        try {
            spDAO.insertSP(sp);
        } catch (SQLException e) {
        	HandleException.printSQLException(e);
        }  
    }
}
