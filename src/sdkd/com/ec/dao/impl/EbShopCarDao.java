package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbShopCar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xuwenchao on 2016/7/8.
 */
public class EbShopCarDao extends BaseDao {
    public List<EbShopCar> getShopCarById(int id)
    {
        String sql = "select A.ep_id, B.eu_user_id, B.esc_product_quantity from easybuy_product A, easybuy_shop_car B " +
                " where B.ep_id = A.ep_id and B.eu_user_id = ?;";
        List<String> list = new ArrayList<String>();
        list.add(Integer.toString(id));
        ResultSet rs = executeSearch(sql, list);
        List<EbShopCar> lt = new ArrayList<EbShopCar>();
        try {
            while(rs.next())
            {
                EbShopCar esc = new EbShopCar(
                        Integer.parseInt(rs.getString("B.eu_user_id")),
                        new EbProductDao().getAProductById(Integer.parseInt(rs.getString("A.ep_id"))),
                        Integer.parseInt(rs.getString("B.esc_product_quantity")));
                lt.add(esc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lt;
    }
}
