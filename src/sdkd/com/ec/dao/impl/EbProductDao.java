package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbProduct;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xuwenchao on 2016/7/7.
 */
public class EbProductDao extends BaseDao {

    public List<EbProduct> getProductsByCateId(int id)
    {
        String sql = "select * from easybuy_product where epc_id = ?;";
        List<String> list = new ArrayList<String>();
        list.add(Integer.toString(id));
        ResultSet rs = executeSearch(sql, list);
        List<EbProduct> pl = new ArrayList<EbProduct>();
        try {
            while(rs.next())
            {
                EbProduct ep = new EbProduct(Integer.parseInt(rs.getString("ep_id")),
                        rs.getString("ep_name"),
                        rs.getString("ep_description"),
                        Double.parseDouble(rs.getString("ep_price")),
                        Integer.parseInt(rs.getString("ep_stock")),
                        Integer.parseInt(rs.getString("epc_id")),
                        Integer.parseInt(rs.getString("epc_child_id")),
                        rs.getString("ep_file_name"),
                        Integer.parseInt(rs.getString("ep_special")));
                pl.add(ep);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pl;
    }
    public EbProduct getAProductById(int id)
    {
        String sql = "select * from easybuy_product where ep_id = ?;";
        List<String> list = new ArrayList<String>();
        list.add(Integer.toString(id));
        ResultSet rs = this.executeSearch(sql, list);
        try {
            if(rs.next())
            {
                EbProduct ep = new EbProduct(Integer.parseInt(rs.getString("ep_id")),
                        rs.getString("ep_name"),
                        rs.getString("ep_description"),
                        Double.parseDouble(rs.getString("ep_price")),
                        Integer.parseInt(rs.getString("ep_stock")),
                        Integer.parseInt(rs.getString("epc_id")),
                        Integer.parseInt(rs.getString("epc_child_id")),
                        rs.getString("ep_file_name"),
                        Integer.parseInt(rs.getString("ep_special")));
                return ep;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<EbProduct> getAllSpecialProduct()
    {
        String sql = "select * from easybuy_product where ep_special = 0;";
        ResultSet rs = this.executeSearch(sql, null);
        List<EbProduct> list = new ArrayList<EbProduct>();
        try {
            while(rs.next())
            {
                EbProduct ep = new EbProduct(Integer.parseInt(rs.getString("ep_id")),
                        rs.getString("ep_name"),
                        rs.getString("ep_description"),
                        Double.parseDouble(rs.getString("ep_price")),
                        Integer.parseInt(rs.getString("ep_stock")),
                        Integer.parseInt(rs.getString("epc_id")),
                        Integer.parseInt(rs.getString("epc_child_id")),
                        rs.getString("ep_file_name"),
                        Integer.parseInt(rs.getString("ep_special")));
                list.add(ep);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<EbProduct> getHotProducts()
    {
        String sql = "select B.*, sum(eod_quantity) sum1 from easybuy_order_detail A, easybuy_product B " +
                " where A.ep_id=B.ep_id group by A.ep_id order by sum1 desc limit 12;";
        ResultSet rs = this.executeSearch(sql, null);
        List<EbProduct> list = new ArrayList<EbProduct>();
        try {
            while(rs.next())
            {
                EbProduct ep = new EbProduct(Integer.parseInt(rs.getString("B.ep_id")),
                        rs.getString("B.ep_name"),
                        rs.getString("B.ep_description"),
                        Double.parseDouble(rs.getString("B.ep_price")),
                        Integer.parseInt(rs.getString("B.ep_stock")),
                        Integer.parseInt(rs.getString("B.epc_id")),
                        Integer.parseInt(rs.getString("B.epc_child_id")),
                        rs.getString("B.ep_file_name"),
                        Integer.parseInt(rs.getString("B.ep_special")));
                list.add(ep);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
