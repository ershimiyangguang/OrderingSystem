package cn.edu.cugb.bean;

public class Order {
    private  Integer dId;
    private  String  uName;
    private  Integer oCount;
    private  Integer  oState;


    public Order() {
    }


    public Order(Integer dId, String uName, Integer oCount, Integer oState) {
        this.dId = dId;
        this.uName = uName;
        this.oCount = oCount;
        this.oState = oState;
    }

    /**
     * 获取
     * @return dId
     */
    public Integer getDId() {
        return dId;
    }

    /**
     * 设置
     * @param dId
     */
    public void setDId(Integer dId) {
        this.dId = dId;
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
     * @return oCount
     */
    public Integer getOCount() {
        return oCount;
    }

    /**
     * 设置
     * @param oCount
     */
    public void setOCount(Integer oCount) {
        this.oCount = oCount;
    }

    /**
     * 获取
     * @return oState
     */
    public Integer getOState() {
        return oState;
    }

    /**
     * 设置
     * @param oState
     */
    public void setOState(Integer oState) {
        this.oState = oState;
    }

    public String toString() {
        return "Order{dId = " + dId + ", uName = " + uName + ", oCount = " + oCount + ", oState = " + oState + "}";
    }
}
