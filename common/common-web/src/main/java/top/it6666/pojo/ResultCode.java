package top.it6666.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResultCode implements IResultCode{
    SUCCESS(200, "响应成功"),
    CANNOT_FIND_USER(210001, "找不到指定的用户"),
    USER_HAS_NO_RIGHT(210002, "用户没有权限"),
    WRONG_PASSWORD(210003, "密码错误"),
    NO_TOKEN(210004, "无法找到token"),
    TOKEN_OUT_OF_DATE(210005, "token 过期"),
    CANNOT_DECRYPT_TOKEN(210006, "无法解析 token"),
    TOKEN_INVALID(210007, "token 无效"),
    HAS_NO_RIGHT(210008, "权限不足"),
    AUTH_FAIL(210009, "认证失败"),
    CANNOT_GET_WECHAT_PHONE(214000, "无法获取微信手机号"),
    WECHAT_SERVICE_BUSY(214001, "微信服务正忙"),
    WECHAT_PHONE_CODE_ERROR(214002, "不合法的code（code不存在、已过期或者使用过）"),
    NULL_WECHAT_PHONE(214003, "未找到微信用户手机号"),
    CANNOT_FOUND_CODE(214005, "无法找到用户信息"),
    EXCEL_NO_DEVICE(215000, "excel没有设备"),
    EXCEL_NAME_ERROR(215002, "excel文件名错误"),
    JSON_INVALID(990001, "JSON 解析错误"),
    ENUM_INVALID_PROPERTY(990002, "解析枚举类型时，未找到指定的属性字段"),
    INVALID_PROPERTY(990003, "字段不存在"),
    EMPTY_FILE(990004, "文件内容为空"),
    INVALID_DATE_PATTERN(990005, "时间格式不正确"),
    DATE_FORMAT_ERROR(990006, "时间格式化出错"),
    REQUEST_PARAM_ERROR(990007, "参数错误"),
    HTTP_MESSAGE_ERROR(990008, "HTTP 请求参数错误"),
    WRONG_REQUEST_HOST(990009, "客户端请求地址错误"),
    FILE_NOT_FOUND(990010, "未找到指定文件"),
    FILE_UPLOAD_ERROR(990011, "文件上传错误"),
    CANNOT_FOUND_DATA(990012, "无法查询到指定数据"),
    PRIMARY_KEY_DUPLICATE(990013, "数据主键重复"),
    PROTOBUF_ERROR(990014, "protobuf 解析错误"),
    ENUM_PARSE_ERROR(990015, "枚举解析错误"),
    DATA_QUERY_FAIL(990016, "查询失败"),
    DATA_ADD_FAIL(990017, "增加失败"),
    KEY_EXISTS(990018, "数据已存在"),
    HTTP_METHOD_ERROR(990019, "HTTP请求方法错误"),
    NO_RIGHT_EDIT(990021, "无权限编辑"),
    NO_RIGHT_DELETE(990022, "无权限删除"),
    PARAM_IS_NULL(400001, "请求必填参数为空"),
    RESOURCE_NOT_FOUND(400002, "请求资源不存在"),
    SYSTEM_EXECUTION_ERROR(999999, "系统执行出错");
    private final Integer code;
    private final String message;
}
