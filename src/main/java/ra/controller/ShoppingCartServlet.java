package ra.controller;

import ra.model.entyti.Cart;
import ra.model.entyti.Product;
import ra.model.service.ProductService;
import ra.model.serviceImp.ProductServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShoppingCartServlet", value = "/ShoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {
    private static ProductService<Product,Integer> productService = new ProductServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("addCart")) {
            int productId = Integer.parseInt(request.getParameter("productId"));
            Product productAdd = new Product();
            for (Product pro : productService.getAll()) {
                if (pro.getProductId() == productId) {
                    productAdd = pro;
                }
            }
            HttpSession session = request.getSession();
            List<Cart> listCart = (List<Cart>) session.getAttribute("listCart");

            if (listCart == null) {
                listCart = new ArrayList<>();
                Cart cart = new Cart(productAdd, 1);
                listCart.add(cart);
            } else {
                boolean checkExist = false;
                for (Cart cart : listCart) {
                    if (cart.getProduct().getProductId() == productId) {
                        cart.setQuantity(cart.getQuantity() + 1);
                        checkExist = true;
                        break;
                    }
                }
                if (!checkExist) {
                    Cart cart = new Cart(productAdd, 1);
                    listCart.add(cart);
                }
            }
            session.setAttribute("listCart", listCart);
            session.setAttribute("totalAmount", calTotalAmount(listCart));
            request.getRequestDispatcher("views/user/cart.jsp").forward(request, response);
        } else if (action.equals("Update")) {
            List<Cart> listCart = (List<Cart>) request.getSession().getAttribute("listCart");
            String[] arrQuantity = request.getParameterValues("quantity");
            for (int i = 0; i < listCart.size(); i++) {
                listCart.get(i).setQuantity(Integer.parseInt(arrQuantity[i]));
            }
            request.getSession().setAttribute("listCart", listCart);
            request.getSession().setAttribute("totalAmount", calTotalAmount(listCart));
            request.getRequestDispatcher("views/user/cart.jsp").forward(request, response);
        } else if (action.equals("Delete")) {
            List<Cart> listCart = (List<Cart>) request.getSession().getAttribute("listCart");
            int productID = Integer.parseInt(request.getParameter("productId"));
            for (int i = 0; i < listCart.size(); i++) {
                if (listCart.get(i).getProduct().getProductId() == productID) {
                    listCart.remove(i);
                }
            }
            request.getSession().setAttribute("listCart", listCart);
            request.getSession().setAttribute("totalAmount", calTotalAmount(listCart));
            request.getRequestDispatcher("views/user/cart.jsp").forward(request, response);
        }
    }
    public static float calTotalAmount(List<Cart> listCart) {
        float totalAmount = 0;
        for (Cart cart : listCart) {
            totalAmount += cart.getQuantity() * cart.getProduct().getPrice();
        }
        return totalAmount;
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
