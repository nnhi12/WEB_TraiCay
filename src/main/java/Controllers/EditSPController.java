package Controllers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Base64;

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


@WebServlet("/EditSPController")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, 
					maxFileSize = 1024 * 1024 * 50,      
					maxRequestSize = 1024 * 1024 * 100)
public class EditSPController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SanPhamDAO spDAO;   

    public EditSPController() {
        super();

    }


	public void init() {
		spDAO = new SanPhamDAO();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException {
		try {
			request.setCharacterEncoding("UTF-8");

	        String MaSP = request.getParameter("maSP");
	        String TenSP = request.getParameter("tenSP");
	        String MaLoaiSP = request.getParameter("maLoaiSP");
	        String soLuongStr = request.getParameter("soLuong");
	        int SoLuong = 0; 
	        if (soLuongStr != null && !soLuongStr.isEmpty()) {
	            SoLuong = Integer.parseInt(soLuongStr);
	        }
	        String DonViTinh = request.getParameter("donViTinh");
	        String giaStr = request.getParameter("gia");
	        float Gia = 0.0f; 
	        if (giaStr != null && !giaStr.isEmpty()) {
	            Gia = Float.parseFloat(giaStr);
	        }
	        Part HinhAnhPart = request.getPart("hinhanh");
	        byte[] HinhAnh = null;
	        if (HinhAnhPart != null) {

	            InputStream hinhAnhStream = HinhAnhPart.getInputStream();
	            HinhAnh = hinhAnhStream.readAllBytes();
	        } else {
	        	String base64Image = request.getParameter("base64Image");
	        	HinhAnh = Base64.getDecoder().decode(base64Image);
	        }
	        System.out.println(HinhAnh);
	        String MaGG = request.getParameter("maGG");
	        String MaNCC = request.getParameter("maNCC");

	        SANPHAM sp = new SANPHAM(MaSP, TenSP, MaLoaiSP, SoLuong, DonViTinh, Gia, HinhAnh, MaGG, MaNCC);

	        spDAO.updateSP(sp);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/EditSP.jsp");
    		request.setAttribute("sanpham", sp);
    		dispatcher.forward(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
