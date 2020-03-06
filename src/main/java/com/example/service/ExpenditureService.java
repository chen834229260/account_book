package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.ExpenditureMapper;
import com.example.vo.ExpenditureVO;
import org.springframework.stereotype.Service;

/**
 * @author: ckx
 * @date: 2020/3/2
 * @description:
 */
@Service
public class ExpenditureService extends ServiceImpl<ExpenditureMapper, ExpenditureVO> {
    /**
     * 添加
     * @param expenditureVO
     */
    public void addExpenditure(ExpenditureVO expenditureVO) {
        expenditureVO.setAddTime(DateUtil.currentSeconds());
        this.save(expenditureVO);
    }
}
