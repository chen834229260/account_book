package com.example.util.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: ckx
 * @date: 2020/6/17
 * @description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageBean {
    /**
     * 请求页
     */
    private Integer page;
    /**
     * 每页几条
     */
    private Integer limit;
}
