package com.example.vo;


import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 支出表
 *
 * @author MTR-007
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("a_expenditure")
public class ExpenditureVO {

    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 金额
     */
    private Double money;
    /**
     * 消费类型
     */
    private Integer category;
    /**
     * 消费品名
     */
    private String name;
    private Long addTime;
    @TableLogic
    private Integer isDelete;


}
