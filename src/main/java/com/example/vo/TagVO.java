package com.example.vo;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 标签表
 *
 * @author MTR-007
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("a_tag")
public class TagVO {

  private Integer id;

  private Integer userId;

  private String tag;

  private Long addTime;
  @TableLogic
  private Integer isDelete;




}
