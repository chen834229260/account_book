package com.example.vo.output;

import java.util.List;

/**
 * @author: ckx
 * @date: 2020/3/10
 * @description:
 */
public interface BeanConvert<S,T> {
    /**
     * 将实体类进行转换
     * @param s
     * @return
     */
    T convert(S s);

    /**
     * 实体类返回list
     * @param s
     * @return
     */
    List<T> convert(List<S> s);
}
