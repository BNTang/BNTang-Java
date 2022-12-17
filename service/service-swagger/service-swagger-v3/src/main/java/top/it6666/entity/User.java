package top.it6666.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "用户信息")
public class User {

    @Schema(description = "姓名")
    private String name;

    @Schema(description = "电话")
    private String phone;
}
