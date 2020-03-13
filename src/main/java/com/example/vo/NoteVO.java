package com.example.vo;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 文本主题表
 *
 * @author MTR-007
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("a_note")
public class NoteVO {


  private Integer id;

  private Integer userId;

  private Integer tagId;

  private String title;

  private String content;

  private Long addTime;

  @TableLogic
  private Integer isDelete;



}
