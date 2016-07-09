package sdkd.com.ec.dao.impl;

import sdkd.com.ec.controller.EbProdCateController;
import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbComment;
import sdkd.com.ec.model.EbProdCate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Xuwenchao on 2016/7/8.
 */
public class EbCommentDao extends BaseDao {
    public List<EbComment> getAllComment()
    {
        String sql = "select * from easybuy_comment;";
        ResultSet rs = executeSearch(sql, null);
        List<EbComment> list = new ArrayList<EbComment>();
        try {
            while (rs.next())
            {
                try {
                    EbComment ec = new EbComment(Integer.parseInt(rs.getString("eu_user_id")),
                    rs.getString("ec_content"),
                    new SimpleDateFormat("yy-MM-dd hh:mm:ss").parse(rs.getString("ec_create_time")));
                    if(rs.getString("ec_reply") != null)
                        ec.setEc_reply(rs.getString("ec_reply"));
                    if(rs.getString("ec_reply_time") != null)
                        ec.setEc_reply_time(new SimpleDateFormat("yy-MM-dd hh:mm:ss").parse(rs.getString("ec_reply_time")));
                    list.add(ec);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addCommentByComment(EbComment ec)
    {
        String sql = "insert into easybuy_comment(eu_user_id, ec_content, ec_create_time) values(?, ?, ?);";
        List<String> list = new ArrayList<String>();
        list.add(Integer.toString(ec.getEu_user_id()));
        list.add(ec.getEc_content());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        list.add(sdf.format(ec.getEc_create_time()));
        return exeucteModify(sql, list) > 0 ? true : false;
    }

}
