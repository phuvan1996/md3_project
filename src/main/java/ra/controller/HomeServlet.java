package ra.controller;

import ra.model.entyti.Catalog;
import ra.model.entyti.Product;
import ra.model.service.CatalogService;
import ra.model.service.ProductService;
import ra.model.serviceImp.CatalogServiceImp;
import ra.model.serviceImp.ProductServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "/HomeServlet")
public class HomeServlet extends HttpServlet {
    private ProductService<Product, Integer> productService = new ProductServiceImp();
    private static CatalogService<Catalog, Integer> catalogService = new CatalogServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("home")){
            request.setAttribute("listproduct",productService.getAll());
            request.getRequestDispatcher("views/user/home.jsp").forward(request,response);
        } else if (action.equals("shop")) {
            request.setAttribute("listproduct",productService.getAll());
            request.setAttribute("listcatalog",catalogService.getAll());
            request.getRequestDispatcher("views/user/shop.jsp").forward(request,response);
        } else if (action.equals("detail")) {
            int productId = Integer.parseInt(request.getParameter("productId"));
            request.setAttribute("pro",productService.getById(productId));
            request.getRequestDispatcher("views/user/product-detail.jsp").forward(request,response);
        }else if (action.equals("product.detail")) {
            int catId = Integer.parseInt(request.getParameter("catId"));
            List<Product> listPro = productService.getProductByCatalogId(catId);
            request.setAttribute("listproduct",listPro);
            request.setAttribute("listcatalog",catalogService.getAll());
            request.setAttribute("catId",catId);
            request.getRequestDispatcher("views/user/shop.jsp").forward(request,response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
