package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.vo.ExpenditureVO;
import org.springframework.stereotype.Repository;

/**
 * @author: ckx
 * @date: 2020/3/2
 * @description:
 */
@Repository
public interface ExpenditureMapper extends BaseMapper<ExpenditureVO> {
    /**
     * 获取总支出
     * @return
     */
    Double getTotalExpenditure();
}
