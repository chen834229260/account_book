package com.example.vo;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MTR-007
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("a_user")
public class UserVO {

    private Integer id;
    private String username;
    private String password;
    private Integer isDelete;


}
