package ra.controller;

import ra.model.entyti.Catalog;
import ra.model.entyti.User;
import ra.model.service.CatalogService;
import ra.model.service.ProductService;
import ra.model.service.UserService;
import ra.model.serviceImp.CatalogServiceImp;
import ra.model.serviceImp.ProductServiceImp;
import ra.model.serviceImp.UserServiceImp;

import javax.jws.soap.SOAPBinding;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    private static UserService userServices = new UserServiceImp();
    private ProductService productServiceImp = new ProductServiceImp();
    private CatalogService<Catalog,Integer> catalogService = new CatalogServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equalsIgnoreCase("GetAll")) {
           GetAllUser(request, response);
        } else if (action != null && action.equalsIgnoreCase("lock")) {
            int userId = Integer.parseInt(request.getParameter("userId"));
            boolean reuslt = userServices.updateUserLock(userId);
            if(reuslt){
                GetAllUser(request,response);
            }else {
                request.getRequestDispatcher("views/admin/error.jsp").forward(request,response);
            }
        } else if (action != null &&action.equalsIgnoreCase("unLock")) {
            int userId = Integer.parseInt(request.getParameter("userId"));
            boolean reuslt = userServices.updateUserUnlock(userId);
            if(reuslt){
                GetAllUser(request,response);
            }else {
                request.getRequestDispatcher("views/admin/error.jsp").forward(request,response);
            }
        } else if (action != null && action.equalsIgnoreCase("Search")) {
            String uName = request.getParameter("searchName");
            request.setAttribute("listUser", userServices.searchByName(uName));
            request.getRequestDispatcher("views/admin/user.jsp").forward(request, response);
        } else if (action != null && action.equalsIgnoreCase("logOut")) {
            HttpSession session = request.getSession();
            session.removeAttribute("account");
            request.setAttribute("listproduct",productServiceImp.getAll());
            List<Catalog> listCatalog = catalogService.getAll();
            request.setAttribute("listcatalog",listCatalog);
            request.getRequestDispatcher("views/user/home.jsp").forward(request,response);
        }
    }
    public void GetAllUser(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        List<User> listUser = userServices.findAll();
        request.setAttribute("listUser",listUser);
        request.getRequestDispatcher("views/admin/user.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("register")){
            String UserName = request.getParameter("username");
            String Email = request.getParameter("email");
            String PassWord = request.getParameter("password");
            String ConfirmPass = request.getParameter("confirmpass");
            User user = new User();
            user.setUserName(UserName);
            user.setEmail(Email);
            user.setPassword(PassWord);
            user.setConfirmPassWord(ConfirmPass);
            boolean checkExit = userServices.register(user);
            if (checkExit){
                request.getRequestDispatcher("views/user/login.jsp").forward(request,response);
            }
        } else if (action.equals("login")) {
            String userName = request.getParameter("username");
            String password = request.getParameter("password");
            User user = userServices.login(userName,password);
            if (user!=null){
                HttpSession session = request.getSession();
                session.setAttribute("userlogin",user);
                if (user.isPermission()){
                    request.getRequestDispatcher("views/admin/catalog.jsp").forward(request,response);
                }else{
                    request.getRequestDispatcher("index.jsp").forward(request,response);
                }
            }else {
                request.getRequestDispatcher("views/user/login.jsp").forward(request,response);
            }
        }
    }
}
