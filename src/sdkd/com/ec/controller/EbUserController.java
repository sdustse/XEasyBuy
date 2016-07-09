package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbUserDao;
import sdkd.com.ec.model.EbUser;

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
public class EbUserController extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        String methname = path.substring(1);
        methname = methname.substring(0, methname.length() - 5);
        System.out.println(methname);
        try {
            Method mt = getClass().getDeclaredMethod(methname, HttpServletRequest.class, HttpServletResponse.class);
            mt.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * queryUser
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void queryUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        EbUserDao newsDao = new EbUserDao();
        request.setCharacterEncoding("UTF-8");
        EbUser auser = newsDao.getByName(request.getParameter("userName"));
        if(auser != null && auser.getEuPassword().equals(request.getParameter("passWord")))
        {
            request.getSession().setAttribute("user", auser);
            new MainPageController().toMain(request, response);
        }
        else
        {

        }
        //System.out.println(auser.getEuPassword());
    }
}
