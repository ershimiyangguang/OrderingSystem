package cn.edu.cugb.bean;

public class Dish {
    private Integer dId;
    private String dName;
    private Integer dPrice;
    private String dDescription;
    private  String dImage;


    public Dish() {
    }

    public Dish(Integer dId, String dName, Integer dPrice, String dDescription, String dImage) {
        this.dId = dId;
        this.dName = dName;
        this.dPrice = dPrice;
        this.dDescription = dDescription;
        this.dImage = dImage;
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
     * @return dName
     */
    public String getDName() {
        return dName;
    }

    /**
     * 设置
     * @param dName
     */
    public void setDName(String dName) {
        this.dName = dName;
    }

    /**
     * 获取
     * @return dPrice
     */
    public Integer getDPrice() {
        return dPrice;
    }

    /**
     * 设置
     * @param dPrice
     */
    public void setDPrice(Integer dPrice) {
        this.dPrice = dPrice;
    }

    /**
     * 获取
     * @return dDescription
     */
    public String getDDescription() {
        return dDescription;
    }

    /**
     * 设置
     * @param dDescription
     */
    public void setDDescription(String dDescription) {
        this.dDescription = dDescription;
    }

    /**
     * 获取
     * @return dImage
     */
    public String getDImage() {
        return dImage;
    }

    /**
     * 设置
     * @param dImage
     */
    public void setDImage(String dImage) {
        this.dImage = dImage;
    }

    public String toString() {
        return "Dish{dId = " + dId + ", dName = " + dName + ", dPrice = " + dPrice + ", dDescription = " + dDescription + ", dImage = " + dImage + "}";
    }
}
