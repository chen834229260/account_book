package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.enmu.ExpenditureEnum;
import com.example.mapper.IncomeMapper;
import com.example.util.UserUtils;
import com.example.vo.IncomeVO;
import org.springframework.stereotype.Service;

/**
 * @author: ckx
 * @date: 2020/3/2
 * @description:
 */
@Service
public class IncomeService extends ServiceImpl<IncomeMapper, IncomeVO> {

    public boolean add(IncomeVO incomeVO) {
        incomeVO.setAddTime(DateUtil.currentSeconds());
        incomeVO.setCategory(ExpenditureEnum.getCode(Integer.valueOf(incomeVO.getCategory())));
        incomeVO.setUserId(UserUtils.getCurrentUser().getId());
        return this.save(incomeVO);
    }
}