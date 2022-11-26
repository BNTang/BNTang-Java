package top.it6666.pojo;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultBody<T> implements Serializable {
    private static final long serialVersionUID = -1474895769101545073L;
    private int code;
    private T data;
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
        return success(null);
    }

    public static <T> ResultBody<T> success(@NonNull T data) {
        ResultBody<T> result = new ResultBody<>();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMessage(ResultCode.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }

    public static <T> ResultBody<T> failed() {
        return result(ResultCode.SYSTEM_EXECUTION_ERROR.getCode(), ResultCode.SYSTEM_EXECUTION_ERROR.getMessage(), null);
    }

    public static <T> ResultBody<T> failed(String msg) {
        return result(ResultCode.SYSTEM_EXECUTION_ERROR.getCode(), msg, null);
    }

    public static <T> ResultBody<T> judge(boolean status) {
        if (status) {
            return success();
        } else {
            return failed();
        }
    }

    public static <T> ResultBody<T> failed(IResultCode resultCode) {
        return result(resultCode.getCode(), resultCode.getMessage(), null);
    }

    public static <T> ResultBody<T> failed(IResultCode resultCode, String msg) {
        return result(resultCode.getCode(), msg, null);
    }

    private static <T> ResultBody<T> result(IResultCode resultCode, T data) {
        return result(resultCode.getCode(), resultCode.getMessage(), data);
    }

    private static <T> ResultBody<T> result(Integer code, String msg, T data) {
        ResultBody<T> result = new ResultBody<>();
        result.setCode(code);
        result.setData(data);
        result.setMessage(msg);
        return result;
    }

    public static boolean isSuccess(ResultBody<?> result) {
        return ResultCode.SUCCESS.getCode().equals(result.getCode());
    }
}
