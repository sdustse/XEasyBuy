package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbNews;
import sdkd.com.ec.model.EbUser;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户DAO
 * Created by SDUST-132 on 2016/7/5.
 */
public class EbUserDao extends BaseDao{
    public EbUser getByName(String name)
    {
        String sql = "select * from easybuy_user where eu_user_name=?;";
        List<String> list = new ArrayList<String>();
        list.add(name);
        ResultSet rs = this.executeSearch(sql,list);
        try {
            if(rs.next())
            {
//                EbUser auser = new EbUser(Integer.parseInt(rs.getString("eu_user_id")), rs.getString("eu_user_name"),
//                        rs.getString("eu_password"), Integer.parseInt(rs.getString("eu_sex")),
//                        new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("eu_birthday")), rs.getString("eu_identity_code"),
//                        rs.getString("eu_email"), rs.getString("eu_mobile"), rs.getString("eu_address"),
//                        Integer.parseInt(rs.getString("eu_status")));
                EbUser auser = new EbUser(Integer.parseInt(rs.getString("eu_user_id")), rs.getString("eu_user_name"),
                        rs.getString("eu_password"), Integer.parseInt(rs.getString("eu_status")));
                return auser;
            }
            else
            {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
