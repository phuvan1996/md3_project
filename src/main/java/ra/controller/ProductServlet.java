package ra.controller;

import ra.model.entyti.Catalog;
import ra.model.entyti.Product;
import ra.model.service.CatalogService;
import ra.model.service.ProductService;
import ra.model.serviceImp.CatalogServiceImp;
import ra.model.serviceImp.ProductServiceImp;
import ra.model.util.ConnectionDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 10
)
public class ProductServlet extends HttpServlet {
    private static CatalogService<Catalog, Integer> catalogService = new CatalogServiceImp();
    private ProductService<Product, Integer> productService = new ProductServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("GetAll")) {
            getAllProduct(request, response);
        } else if (action != null && action.equals("addNewProduct")) {
            List<Catalog> catalogList = catalogService.getForCreatProduct();
            request.setAttribute("listCreat", catalogList);
            request.getRequestDispatcher("views/admin/newproduct.jsp").forward(request, response);
        } else if (action.equals("delete")) {
            int productId = Integer.parseInt(request.getParameter("productId"));
            boolean result = productService.delete(productId);
            if (result) {
                getAllProduct(request, response);
            }
        } else if (action.equals("update")) {
            int productId = Integer.parseInt(request.getParameter("productId"));
            List<Catalog> catalogList = catalogService.getForCreatProduct();
            request.setAttribute("listCreat", catalogList);
            Product productupdate = productService.getById(productId);
            request.setAttribute("productUpdate", productupdate);
            request.getRequestDispatcher("views/admin/updateproduct.jsp").forward(request, response);
        } else if (action.equals("GetById")) {
            int productId = Integer.parseInt(request.getParameter("productId"));
            Connection conn = null;
            CallableStatement callst = null;
            Product pro = null;
            try {
                conn = ConnectionDB.openConnection();
                callst = conn.prepareCall("{call proc_getproductbyid(?)}");
                callst.setInt(1, productId);
                ResultSet rs = callst.executeQuery();
                pro = new Product();
                if (rs.next()) {
                    pro.setProductId(rs.getInt("ProductId"));
                    pro.setProductName(rs.getString("ProductName"));
                    pro.setPrice(rs.getFloat("Price"));
                    pro.setQuantity(rs.getInt("Quantity"));
                    pro.setTitle(rs.getString("ProductTitle"));
                    pro.setDescription(rs.getString("productDescription"));
                    pro.setProductImage(rs.getString("ProductImage"));
                    pro.setProductStatus(rs.getBoolean("ProductStatus"));
                    pro.setCatalogId(rs.getInt("CatalogId"));
                }
                CallableStatement callst2 = conn.prepareCall("{call proc_getimageById(?)}");
                callst2.setInt(1, productId);
                ResultSet rs2 = callst2.executeQuery();
                while (rs2.next()) {
                    pro.getListImageUrl().add(rs2.getString("ImageUrl"));
                }
                callst2.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                ConnectionDB.closeConnection(conn, callst);
            }
            request.setAttribute("pro", pro);
            request.getRequestDispatcher("views/admin/productDetail.jsp").forward(request, response);
        } else if (action != null && action.equals("search")) {
            String proName = request.getParameter("search");
            request.setAttribute("listproduct", productService.searchByName(proName));
            request.getRequestDispatcher("views/admin/product.jsp").forward(request, response);
        } else {
            getAllProduct(request, response);
        }
    }

    public void getAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> listPro = productService.getAll();
        request.setAttribute("listproduct", listPro);
        request.getRequestDispatcher("views/admin/product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action.equals("Create")) {
            Product proNew = new Product();
            proNew.setProductName(request.getParameter("productName"));
            proNew.setPrice(Float.parseFloat(request.getParameter("price")));
            proNew.setQuantity(Integer.parseInt(request.getParameter("quantity")));
            proNew.setTitle(request.getParameter("title"));
            proNew.setDescription(request.getParameter("description"));
            proNew.setProductImage(request.getParameter("image"));
            proNew.setProductStatus(Boolean.parseBoolean(request.getParameter("productStatus")));
            proNew.setCatalogId(Integer.parseInt(request.getParameter("catalog")));
            String pathFolderImage = "D:/MD3/PROJECT_MD3/src/main/webapp/images";
            File file = new File(pathFolderImage);
            if (!file.exists()) {
                file.mkdir();
            }
            for (Part part : request.getParts()) {
                if (part.getName().equals("image")) {
                    proNew.setProductImage(part.getSubmittedFileName());
                    part.write(pathFolderImage + File.separator + part.getSubmittedFileName());
                } else if (part.getName().equals("subImage")) {
                    proNew.getListImageUrl().add(part.getSubmittedFileName());
                    part.write(pathFolderImage + File.separator + part.getSubmittedFileName());
                }
            }
            boolean result = productService.save(proNew);
            if (result) {
                getAllProduct(request, response);
            }

        } else if (action.equals("update")) {
            Product proupdate = new Product();
            proupdate.setProductId(Integer.parseInt(request.getParameter("productId")));
            proupdate.setProductName(request.getParameter("productName"));
            proupdate.setPrice(Float.parseFloat(request.getParameter("price")));
            proupdate.setQuantity(Integer.parseInt(request.getParameter("quantity")));
            proupdate.setTitle(request.getParameter("title"));
            proupdate.setDescription(request.getParameter("prodes"));
            proupdate.setProductImage(request.getParameter("proimage"));
            proupdate.setProductStatus(Boolean.parseBoolean(request.getParameter("productStatus")));
            proupdate.setCatalogId(Integer.parseInt(request.getParameter("catid")));
            String pathFolderImage = "D:/MD3/PROJECT_MD3/src/main/webapp/images";
            File file = new File(pathFolderImage);
            if (!file.exists()) {
                file.mkdir();
            }
            boolean checkUpdateSubImage = false;
            for (Part part : request.getParts()) {
                if (part.getName().equals("proimage")) {
                    if (part.getSubmittedFileName() != "") {
                        //Cap nhat anh chinh cua san pham
                        proupdate.setProductImage(part.getSubmittedFileName());
                        part.write(pathFolderImage + File.separator + part.getSubmittedFileName());
                    } else {
                        //KHong cap nhat anh chinh cua san pham
                        proupdate.setProductImage(request.getParameter("oldProImage"));
                    }
                } else if (part.getName().equals("subImage")) {
                    if (part.getSubmittedFileName() != "") {
                        //Co cap nhat anh phu
                        checkUpdateSubImage = true;
                        proupdate.getListImageUrl().add(part.getSubmittedFileName());
                        part.write(pathFolderImage + File.separator + part.getSubmittedFileName());
                    }
                }
            }
            if (!checkUpdateSubImage) {
                String[] arrSubImageOld = request.getParameterValues("oldSubImg");
                for (String str : arrSubImageOld) {
                    proupdate.getListImageUrl().add(str);
                }
            }
            boolean result1 = productService.update(proupdate);
            if (result1) {
                getAllProduct(request, response);
            }
        }
    }
}
