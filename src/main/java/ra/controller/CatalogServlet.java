package ra.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ra.model.entyti.Catalog;
import ra.model.service.CatalogService;
import ra.model.serviceImp.CatalogServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@WebServlet(name = "CatalogServlet", value = "/CatalogServlet")
public class CatalogServlet extends HttpServlet {
    private static CatalogService<Catalog,Integer>catalogService= new CatalogServiceImp();
    private static final Gson GSON = new GsonBuilder().create();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action.equals("GetAll")){
            getAllCatalog(request,response);
        } else if (action.equals("GetById")) {
            int catalogId = Integer.parseInt(request.getParameter("catalogId"));
            Catalog catUpdate = catalogService.getById(catalogId);
            String json = GSON.toJson(catUpdate);
            response.setStatus(200);
            response.setHeader("Content-Type","application/json");
            Writer out = response.getWriter();
            out.write(json);
            out.flush();
        } else if (action!=null&&action.equals("search")) {
            String catName=request.getParameter("search");
            request.setAttribute("listcatalog",catalogService.searchByName(catName));
            request.getRequestDispatcher("views/admin/catalog.jsp").forward(request,response);
        }else {
            getAllCatalog(request,response);
        }

    }
    public void getAllCatalog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Catalog> listCatalog = catalogService.getAll();
        request.setAttribute("listcatalog", listCatalog);
        request.getRequestDispatcher("views/admin/catalog.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("Create")){
            Catalog catalog = new Catalog();
            catalog.setCatalogName(request.getParameter("catalogName"));
            catalog.setTitle(request.getParameter("catatlogtitle"));
            catalog.setCatalogStatus(Boolean.parseBoolean(request.getParameter("status")));
            boolean result = catalogService.save(catalog);
            if (result){
                getAllCatalog(request,response);
            }
        } else if (action.equals("delete")) {
            int catalogId = Integer.parseInt(request.getParameter("catDeleteId"));
            boolean result = catalogService.delete(catalogId);
            if (result){
                getAllCatalog(request,response);
            }else {
                request.getRequestDispatcher("views/admin/error.jsp").forward(request,response);
            }
        } else if (action.equalsIgnoreCase("Update")) {
            Catalog catInfo = new Catalog();
            catInfo.setCatalogId(Integer.parseInt(request.getParameter("catalogId")));
            catInfo.setCatalogName(request.getParameter("catalogName"));
            catInfo.setTitle(request.getParameter("catalogtitle"));
            catInfo.setCatalogStatus(Boolean.parseBoolean(request.getParameter("status")));
            boolean result = catalogService.update(catInfo);
            if (result){
                getAllCatalog(request,response);
            }
        }
    }
}
