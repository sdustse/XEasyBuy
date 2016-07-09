package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbShopCarDao;
import sdkd.com.ec.model.EbShopCar;
import sdkd.com.ec.model.EbUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by Xuwenchao on 2016/7/8.
 */
public class EbShopCarController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        String methname = path.substring(1);
        methname = methname.substring(0, methname.length() - 3);
        try {
            Method mt = getClass().getDeclaredMethod(methname, HttpServletRequest.class, HttpServletResponse.class);
            mt.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getShopCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if(request.getSession().getAttribute("user") == null)
        {
            response.sendRedirect("/login.jsp");
            return;
        }
        EbShopCarDao escd = new EbShopCarDao();
        EbUser eu = (EbUser) request.getSession().getAttribute("user");
        List<EbShopCar> list = escd.getShopCarById(eu.getEuId());
        request.setAttribute("shopcarlist", list);
        request.getRequestDispatcher("shopping.jsp").forward(request, response);
    }
}
