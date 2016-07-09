package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbProdCateDao;
import sdkd.com.ec.dao.impl.EbProductDao;
import sdkd.com.ec.model.EbProdCate;
import sdkd.com.ec.model.EbProduct;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by Xuwenchao on 2016/7/7.
 */
public class EbProdCateController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        String methname = path.substring(1);
        methname = methname.substring(0, methname.length() - 4);
        try {
            Method mt = getClass().getDeclaredMethod(methname, HttpServletRequest.class, HttpServletResponse.class);
            mt.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAllProductCate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        EbProdCateDao ecd = new EbProdCateDao();
        List<EbProdCate> list = ecd.getAllProdCate();
        request.setAttribute("prodcates", list);
        //request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    private void toProductList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        EbProductDao ed = new EbProductDao();
        List<EbProduct> list = ed.getProductsByCateId(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("prodlist", list);
        getAllProductCate(request, response);
        request.getRequestDispatcher("/product_list.jsp").forward(request, response);
    }

}
