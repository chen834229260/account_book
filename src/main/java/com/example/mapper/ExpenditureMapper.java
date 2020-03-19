package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.vo.ExpenditureVO;
import com.example.vo.IconData;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: ckx
 * @date: 2020/3/2
 * @description:
 */
@Repository
public interface ExpenditureMapper extends BaseMapper<ExpenditureVO> {
    /**
     * 获取总支出
     *
     * @return
     */
    Double getTotalExpenditure();

    /**
     * 饼图统计数据获取
     *
     * @return
     */
    List<IconData> iconData();
}
