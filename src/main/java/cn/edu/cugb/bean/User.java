package cn.edu.cugb.bean;

public class User {
    private  Integer uId;
    private  String uName;
    private  String uPassword;


    public User() {
    }

    public User(Integer uId, String uName, String uPassword) {
        this.uId = uId;
        this.uName = uName;
        this.uPassword = uPassword;
    }

    /**
     * 获取
     * @return uId
     */
    public Integer getUId() {
        return uId;
    }

    /**
     * 设置
     * @param uId
     */
    public void setUId(Integer uId) {
        this.uId = uId;
    }

    /**
     * 获取
     * @return uName
     */
    public String getUName() {
        return uName;
    }

    /**
     * 设置
     * @param uName
     */
    public void setUName(String uName) {
        this.uName = uName;
    }

    /**
     * 获取
     * @return uPassword
     */
    public String getUPassword() {
        return uPassword;
    }

    /**
     * 设置
     * @param uPassword
     */
    public void setUPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String toString() {
        return "User{uId = " + uId + ", uName = " + uName + ", uPassword = " + uPassword + "}";
    }

}
