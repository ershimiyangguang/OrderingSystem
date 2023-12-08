package cn.edu.cugb.bean;

public class User {
    private  String uName;
    private  String uPassword;


    public User() {
    }


    public User(String uName, String uPassword) {
        this.uName = uName;
        this.uPassword = uPassword;
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
        return "User{uName = " + uName + ", uPassword = " + uPassword + "}";
    }
}
