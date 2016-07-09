package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbProdCate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xuwenchao on 2016/7/7.
 */
public class EbProdCateDao extends BaseDao {
    public List<EbProdCate> getAProdCate()
    {
        return null;
    }
    public List<EbProdCate> getAllProdCate()
    {
        String sql = "select * from easybuy_product_category;";
        ResultSet rs = this.executeSearch(sql, null);
        List<EbProdCate> list = new ArrayList<EbProdCate>();
        try {
            while(rs.next())
            {
                list.add(new EbProdCate(Integer.parseInt(rs.getString("epc_id")),
                        rs.getString("epc_name"), Integer.parseInt(rs.getString("epc_parent_id"))));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
