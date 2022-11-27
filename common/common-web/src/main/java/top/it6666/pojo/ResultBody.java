package top.it6666.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultBody<T> implements Serializable {
    private static final long serialVersionUID = -1474895769101545073L;
    /**
     * 状态码
     */
    private int code;
    /**
     * java中的Serializable提供一种持久化机制，将实现了Serializable接口的对象序列化为字节序列，并在以后可以将此字节序列恢复为
     * java对象。序列化实现了数据的持久化，保存在硬盘中，并且在网络上进行字节序列的传送。
     * transient：在序列化时，若字段定义为transient,则会自动对该字段不进行序列化。不让序列化机制进行自动保存与恢复，则加上transient
     * 举例说明：
     * 注意：在对字节序列进行反序列化的过程中，没有调用任何的构造器，包括默认的构造器，整个对象都是通过从InputStream 中去得数据而进行恢复的。
     * 举例：分析pswd仍然是空值，即使在构造方法中已经对其进行了初始化，但是在恢复的过程中只是调用了序列化后的InputStream中的值，
     * 而序列化后的pswd为空值，反序列化也为空。
     * 要序列化一个对象，首先，创建某些OutputStream(例如：FileOutputStream)对象，然后将其封装在ObjectOutputStream对象中，
     * 然后调用，writeObject方法，并将其发送给OutputStream，即可进行序列化，反序列化基本相同只不过是读出。
     */
    private transient T data;
    /**
     * 响应消息
     */
    private String message;

    public ResultBody(int code) {
        this.code = code;
    }

    public ResultBody(T body) {
        this.code = ResultCode.SUCCESS.getCode();
        this.data = body;
    }

    public ResultBody(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public static <T> ResultBody<T> success() {
        ResultBody<T> result = new ResultBody<>();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMessage(ResultCode.SUCCESS.getMessage());
        return result;
    }

    public static <T> ResultBody<T> failed() {
        return result(ResultCode.SYSTEM_EXECUTION_ERROR.getCode(), ResultCode.SYSTEM_EXECUTION_ERROR.getMessage());
    }

    public static <T> ResultBody<T> failed(String msg) {
        return result(ResultCode.SYSTEM_EXECUTION_ERROR.getCode(), msg);
    }

    public static <T> ResultBody<T> judge(boolean status) {
        if (status) {
            return success();
        }
        return failed();
    }

    public static <T> ResultBody<T> failed(IResultCode resultCode) {
        return result(resultCode.getCode(), resultCode.getMessage());
    }

    public static <T> ResultBody<T> failed(IResultCode resultCode, String msg) {
        return result(resultCode.getCode(), msg);
    }

    public static boolean isSuccess(ResultBody<?> result) {
        return ResultCode.SUCCESS.getCode().equals(result.getCode());
    }

    public static <T> ResultBody<T> result(T date) {
        ResultBody<T> result = new ResultBody<>();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMessage(ResultCode.SUCCESS.getMessage());
        result.setData(date);
        return result;
    }

    private static <T> ResultBody<T> result(Integer code, String msg) {
        ResultBody<T> result = new ResultBody<>();
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }
}