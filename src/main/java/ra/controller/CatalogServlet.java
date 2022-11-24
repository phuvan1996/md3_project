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
import java.util.List;

@WebServlet(name = "CatalogServlet", value = "/CatalogServlet")
public class CatalogServlet extends HttpServlet {
    private CatalogService<Catalog, Integer> catalogService = new CatalogServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("update")) {
            String catalogId = request.getParameter("catalogId");
            Catalog catalogUpdate = catalogService.getById(Integer.valueOf(catalogId));
            request.setAttribute("catalogupdate", catalogUpdate);
            request.getRequestDispatcher("views/admin/updatecatalog.jsp").forward(request, response);
        } else if (action.equals("delete")) {
            String catalogId = request.getParameter("catalogId");
            boolean result = catalogService.delete(Integer.valueOf(catalogId));
            if (result) {
                getAllCatalog(request, response);
            } else {
                request.getRequestDispatcher("views/error.jsp").forward(request, response);
            }
        } else if (action.equals("search")) {
            String productSearch = request.getParameter("catalogsearch");
            request.setAttribute("listcatalog", catalogService.searchByName(productSearch));
            request.getRequestDispatcher("views/admin/catalog.jsp").forward(request, response);
        } else if (action.equals("catalog")) {
            getAllCatalog(request,response);
        } else {
            //GetAll
            request.getRequestDispatcher("views/admin/index.jsp").forward(request,response);
        }
    }
    public void getAllCatalog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Catalog> listCatalog = catalogService.getAll();
        request.setAttribute("listcatalog", listCatalog);
        request.getRequestDispatcher("views/admin/catalog.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        Catalog cat = new Catalog();
        cat.setCatalogId(Integer.parseInt(request.getParameter("catalogId")));
        cat.setCatalogName(request.getParameter("catalogName"));
        cat.setCatalogStatus(Boolean.parseBoolean(request.getParameter("catalogStatus")));
        if (action != null && action.equals("Create")) {
            boolean result = catalogService.save(cat);
            if (result) {
               getAllCatalog(request, response);
            } else {
                request.getRequestDispatcher("views/admin/error.jsp").forward(request, response);
            }
        } else if (action != null && action.equals("update")) {
            boolean result = catalogService.update(cat);
            if (result) {
                getAllCatalog(request, response);
            } else {
                request.getRequestDispatcher("views/admin/error.jsp").forward(request, response);
            }
        }
    }
}
