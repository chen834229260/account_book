package com.example.vo.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: ckx
 * @date: 2020/6/18
 * @description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BeanOuput<S> {

    /**
     * 结果集
     */
    List<S> records;

    /**
     *
     */
    long total;


}
