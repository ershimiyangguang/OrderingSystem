package cn.edu.cugb.bean;


public class Message<T> {
    /*状态码,
    * 状态码为0表示无问题
    * 状态码为x表示第x个参数有误*/
    private int code;
    /*错误原因
    * 状态码为0时可不写*/
    private String reason;
    /*返回查询对象
    * 无返回对象时可不写*/
    private T object;

    public Message() {
    }

    public Message(int code, String reason, T object) {
        this.code = code;
        this.reason = reason;
        this.object = object;
    }

    /**
     * 获取
     * @return code
     */
    public int getCode() {
        return code;
    }

    /**
     * 设置
     * @param code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * 获取
     * @return reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * 设置
     * @param reason
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * 获取
     * @return object
     */
    public T getObject() {
        return object;
    }

    /**
     * 设置
     * @param object
     */
    public void setObject(T object) {
        this.object = object;
    }

    public String toString() {
        return "Message{code = " + code + ", reason = " + reason + ", object = " + object + "}";
    }
}
