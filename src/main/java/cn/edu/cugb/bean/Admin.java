package cn.edu.cugb.bean;

public class Admin {
    private String aName;
    private String aPassword;

    public Admin() {
    }

    public Admin(String aName, String aPassword) {
        this.aName = aName;
        this.aPassword = aPassword;
    }

    /**
     * 获取
     * @return aName
     */
    public String getAName() {
        return aName;
    }

    /**
     * 设置
     * @param aName
     */
    public void setAName(String aName) {
        this.aName = aName;
    }

    /**
     * 获取
     * @return aPassword
     */
    public String getAPassword() {
        return aPassword;
    }

    /**
     * 设置
     * @param aPassword
     */
    public void setAPassword(String aPassword) {
        this.aPassword = aPassword;
    }

    public String toString() {
        return "Admin{aName = " + aName + ", aPassword = " + aPassword + "}";
    }
}
