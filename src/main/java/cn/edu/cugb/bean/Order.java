package cn.edu.cugb.bean;

public class Order {
    private  Integer dId;
    private  Integer uId;
    private  Integer oCount;
    private  Integer  oState;


    public Order() {
    }

    public Order(Integer dId, Integer uId, Integer oCount, Integer oState) {
        this.dId = dId;
        this.uId = uId;
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
        return "order{dId = " + dId + ", uId = " + uId + ", oCount = " + oCount + ", oState = " + oState + "}";
    }
}
