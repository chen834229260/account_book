package com.example.vo;


import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 收入表
 *
 * @author MTR-007
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("a_income")
public class IncomeVO {

    private Integer id;
    /**
     * 用户
     */
    private Integer userId;
    /**
     * 金额
     */
    private Double money;
    /**
     * 收入类型
     */
    private Integer category;
    private Long addTime;
    @TableLogic
    private Integer isDelete;


}
