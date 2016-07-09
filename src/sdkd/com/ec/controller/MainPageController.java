package sdkd.com.ec.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by Xuwenchao on 2016/7/7.
 */
public class MainPageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        toMain(request, response);
    }
    public void toMain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        new EbNewsController().getAllNews(request, response);
        new EbProdCateController().getAllProductCate(request, response);
        EbProductController epc = new EbProductController();
        epc.getHotProds(request, response);
        epc.getSpecialProd(request, response);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
