package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbCommentDao;
import sdkd.com.ec.model.EbComment;
import sdkd.com.ec.model.EbUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

/**
 * Created by Xuwenchao on 2016/7/8.
 */
public class EbCommentController extends HttpServlet {
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

    private void getAllComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        EbCommentDao ecd = new EbCommentDao();
        List<EbComment> list = ecd.getAllComment();
        new EbProdCateController().getAllProductCate(request, response);
        request.setAttribute("comtlist", list);
        request.getRequestDispatcher("/guestbook.jsp").forward(request, response);
    }

    private void addComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        if(request.getSession().getAttribute("user") == null)
        {
            response.sendRedirect("/login.jsp");
            return;
        }
        EbCommentDao ecd = new EbCommentDao();
        EbUser eu = (EbUser) request.getSession().getAttribute("user");
        if(ecd.addCommentByComment(new EbComment(eu.getEuId(), request.getParameter("guestContent"), new Date())))
        {
            getAllComment(request, response);
        }
        else
        {
            //添加失败
        }
    }

//    public static void main(String[] args) {
//        EbCommentDao ecd = new EbCommentDao();
//        List<EbComment> list = ecd.getAllComment();
//        for(EbComment ec:list)
//        {
//            System.out.println(ec.getEc_content());
//        }
//
//    }
    }
