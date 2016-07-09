package sdkd.com.ec.model;

import java.util.Date;

/**
 * Created by Xuwenchao on 2016/7/8.
 */
public class EbComment {
    private int eu_user_id;
    private String ec_reply;
    private String ec_content;
    private Date ec_create_time;
    private Date ec_reply_time;

    public EbComment(int eu_user_id, String ec_content, Date ec_create_time) {
        this.eu_user_id = eu_user_id;
        this.ec_content = ec_content;
        this.ec_create_time = ec_create_time;
    }

    public EbComment(int ec_id, int eu_user_id, String ec_reply, String ec_content, Date ec_create_time, Date ec_reply_time) {
        this.eu_user_id = eu_user_id;
        this.ec_reply = ec_reply;
        this.ec_content = ec_content;
        this.ec_create_time = ec_create_time;
        this.ec_reply_time = ec_reply_time;
    }

    public int getEu_user_id() {
        return eu_user_id;
    }

    public void setEu_user_id(int eu_user_id) {
        this.eu_user_id = eu_user_id;
    }

    public String getEc_reply() {
        return ec_reply;
    }

    public void setEc_reply(String ec_reply) {
        this.ec_reply = ec_reply;
    }

    public String getEc_content() {
        return ec_content;
    }

    public void setEc_content(String ec_content) {
        this.ec_content = ec_content;
    }

    public Date getEc_create_time() {
        return ec_create_time;
    }

    public void setEc_create_time(Date ec_create_time) {
        this.ec_create_time = ec_create_time;
    }

    public Date getEc_reply_time() {
        return ec_reply_time;
    }

    public void setEc_reply_time(Date ec_reply_time) {
        this.ec_reply_time = ec_reply_time;
    }
}
