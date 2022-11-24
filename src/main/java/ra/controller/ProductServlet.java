package ra.controller;

import ra.model.entyti.Product;
import ra.model.service.ProductService;
import ra.model.serviceImp.ProductServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private ProductService<Product, String> productService = new ProductServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("update")) {
            String productId = request.getParameter("productId");
            Product productUpdate = productService.getById(productId);
            request.setAttribute("productupdate", productUpdate);
            request.getRequestDispatcher("views/admin/updateproduct.jsp").forward(request, response);
        } else if (action != null && action.equals("delete")) {
            String productId = request.getParameter("productId");
            boolean result = productService.delete(productId);
            if (result) {
                getAllProduct(request, response);
            } else {
                request.getRequestDispatcher("views/admin/error.jsp").forward(request, response);
            }
        } else if (action != null && action.equals("search")) {
            String productSearch = request.getParameter("productsearch");
            request.setAttribute("listproduct", productService.searchByName(productSearch));
            request.getRequestDispatcher("views/admin/product.jsp").forward(request, response);
        } else if (action != null && action.equals("product")) {
            getAllProduct(request,response);
        } else {
            request.getRequestDispatcher("views/admin/index.jsp").forward(request,response);
        }
    }
    public void getAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> listProduct = productService.getAll();
        request.setAttribute("listproduct", listProduct);
        request.getRequestDispatcher("views/admin/product.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        Product pro = new Product();
        pro.setProductId(request.getParameter("productId"));
        pro.setProductName(request.getParameter("productName"));
        pro.setPrice(Float.parseFloat(request.getParameter("price")));
        pro.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        pro.setProductImage(request.getParameter("productImage"));
        pro.setTitle(request.getParameter("title"));
        pro.setProductStatus(Boolean.parseBoolean(request.getParameter("productStatus")));
        if (action != null && action.equals("Create")) {
            boolean result = productService.save(pro);
            if (result) {
                getAllProduct(request, response);
            } else {
                request.getRequestDispatcher("views/admin/error.jsp").forward(request, response);
            }
        } else if (action != null && action.equals("update")) {
            boolean result = productService.update(pro);
            if (result) {
                getAllProduct(request, response);
            } else {
                request.getRequestDispatcher("views/admin/error.jsp").forward(request, response);
            }
        }
    }
}
