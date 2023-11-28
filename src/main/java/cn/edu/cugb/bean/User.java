package cn.edu.cugb.bean;

import java.sql.Date;

public class User {
    /*密码*/
    private int uid;
    /*用户名*/
    private String uname;
    /*密码*/
    private String password;
    /*创建日期*/
    private Date createdate;

    public User() {
    }

    public User(int uid, String uname, String password, Date createdate) {
        this.uid = uid;
        this.uname = uname;
        this.password = password;
        this.createdate = createdate;
    }

    /**
     * 获取
     * @return uid
     */
    public int getUid() {
        return uid;
    }

    /**
     * 设置
     * @param uid
     */
    public void setUid(int uid) {
        this.uid = uid;
    }

    /**
     * 获取
     * @return uname
     */
    public String getUname() {
        return uname;
    }

    /**
     * 设置
     * @param uname
     */
    public void setUname(String uname) {
        this.uname = uname;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return createdate
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 设置
     * @param createdate
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String toString() {
        return "User{uid = " + uid + ", uname = " + uname + ", password = " + password + ", createdate = " + createdate + "}";
    }
}
