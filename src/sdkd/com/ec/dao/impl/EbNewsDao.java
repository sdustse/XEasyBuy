package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbNews;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SDUST-132 on 2016/7/6.
 */
public class EbNewsDao extends BaseDao {
    public List<EbNews> getNews(){
        List<EbNews> newsList = new ArrayList<EbNews>();
        String sql = "select * from easybuy_news order by en_create_time desc limit 0,7";
        try {
            ResultSet rs = this.executeSearch(sql,null);
            while (rs.next()){
                EbNews news = new EbNews();
                news.setEnId(rs.getInt("en_id"));
                news.setEnTitle(rs.getString("en_title"));
                //添加到集合中
                newsList.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newsList;
    }

    public EbNews getANewById(int id){
        String sql = "select en_title,en_content,en_create_time from easybuy_news where en_id = ?;";
        List<String> list = new ArrayList<String>();
        list.add(Integer.toString(id));
        ResultSet rs = this.executeSearch(sql,list);
        EbNews anew = new EbNews();
        try {
            if(rs.next())
            {
                anew.setEnId(id);
                anew.setEnTitle(rs.getString("en_title"));
                anew.setEnContent(rs.getString("en_content"));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String str = rs.getString("en_create_time");
                anew.setEnCreateTime(sdf.parse(str));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return anew;
    }
}
