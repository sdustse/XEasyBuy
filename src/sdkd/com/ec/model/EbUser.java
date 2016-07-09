package sdkd.com.ec.model;

import java.util.Date;

/**
 * 用户表
 * Created by Xuwenchao on 2016/7/5.
 */
public class EbUser {
    private int euId;
    private String euName;
    private String euPassword;
    private int euSex;
    private Date euBirthday;
    private String euCode;
    private String euEmail;
    private String euMobile;
    private String euAddress;
    private int euStatus;

    public EbUser(int euId, String euName, String euPassword, int euSex, Date euBirthday, String euCode, String euEmail, String euMobile, String euAddress, int euStatus) {
        this.euId = euId;
        this.euName = euName;
        this.euPassword = euPassword;
        this.euSex = euSex;
        this.euBirthday = euBirthday;
        this.euCode = euCode;
        this.euEmail = euEmail;
        this.euMobile = euMobile;
        this.euAddress = euAddress;
        this.euStatus = euStatus;
    }

    public EbUser(int euId, String euName, String euPassword, int euStatus) {
        this.euId = euId;
        this.euName = euName;
        this.euPassword = euPassword;
        this.euStatus = euStatus;
    }

    public int getEuId() {
        return euId;
    }

    public void setEuId(int euId) {
        this.euId = euId;
    }

    public String getEuName() {
        return euName;
    }

    public void setEuName(String euName) {
        this.euName = euName;
    }

    public String getEuPassword() {
        return euPassword;
    }

    public void setEuPassword(String euPassword) {
        this.euPassword = euPassword;
    }

    public int getEuSex() {
        return euSex;
    }

    public void setEuSex(int euSex) {
        this.euSex = euSex;
    }

    public Date getEuBirthday() {
        return euBirthday;
    }

    public void setEuBirthday(Date euBirthday) {
        this.euBirthday = euBirthday;
    }

    public String getEuCode() {
        return euCode;
    }

    public void setEuCode(String euCode) {
        this.euCode = euCode;
    }

    public String getEuEmail() {
        return euEmail;
    }

    public void setEuEmail(String euEmail) {
        this.euEmail = euEmail;
    }

    public String getEuMobile() {
        return euMobile;
    }

    public void setEuMobile(String euMobile) {
        this.euMobile = euMobile;
    }

    public String getEuAddress() {
        return euAddress;
    }

    public void setEuAddress(String euAddress) {
        this.euAddress = euAddress;
    }

    public int getEuStatus() {
        return euStatus;
    }

    public void setEuStatus(int euStatus) {
        this.euStatus = euStatus;
    }
}
