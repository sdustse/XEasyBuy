package sdkd.com.ec.controller;

import com.sun.deploy.net.HttpRequest;
import sdkd.com.ec.dao.impl.EbNewsDao;
import sdkd.com.ec.model.EbNews;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by SDUST-132 on 2016/7/6.
 */
public class EbNewsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
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


        /**
         *  getAllNews
         */
        public void getAllNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
            EbNewsDao newsDao = new EbNewsDao();
            List<EbNews> list = newsDao.getNews();
            request.setAttribute("newsList", list);
            //request.getRequestDispatcher("/index.jsp").forward(request, response);
        }

    /**
     * getANew
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
        private void getANew(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
            EbNewsDao newsDao = new EbNewsDao();
            EbNews anew = newsDao.getANewById(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("anew", anew);
            List<EbNews> list = newsDao.getNews();
            request.setAttribute("newsList", list);
            request.getRequestDispatcher("/news-view.jsp").forward(request, response);
        }

}
