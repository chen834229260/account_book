package com.example.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: ckx
 * @date: 2020/3/9
 * @description:统计输出实体类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("v_account")
public class StatisticsVO {

    private Integer userId;

    private Double money;

    private String category;

    private Long addTime;

}
