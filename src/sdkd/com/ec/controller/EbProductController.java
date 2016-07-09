package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbProductDao;
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
public class EbProductController extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        String methname = path.substring(1);
        methname = methname.substring(0, methname.length() - 5);
        try {
            Method mt = getClass().getDeclaredMethod(methname, HttpServletRequest.class, HttpServletResponse.class);
            mt.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * getSpecialProd
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void getSpecialProd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        EbProductDao epd = new EbProductDao();
        List<EbProduct> list = epd.getAllSpecialProduct();
        req.setAttribute("special", list);
        //req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    /**
     * getHotProd
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void getHotProds(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        EbProductDao epd = new EbProductDao();
        List<EbProduct> list = epd.getHotProducts();
        req.setAttribute("hotproducts", list);
        //req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    private void getAProd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        EbProduct ep = new EbProductDao().getAProductById(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("aproduct", ep);
        req.getRequestDispatcher("/product-view.jsp").forward(req, resp);
    }
}
