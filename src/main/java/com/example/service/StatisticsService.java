package com.example.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.ExpenditureMapper;
import com.example.mapper.IncomeMapper;
import com.example.mapper.StatisticsMapper;
import com.example.util.UserUtils;
import com.example.vo.IconData;
import com.example.vo.StatisticsVO;
import com.example.vo.output.StatisticsOutput;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ckx
 * @date: 2020/3/9
 * @description:
 */
@Service
public class StatisticsService extends ServiceImpl<StatisticsMapper, StatisticsVO> {

    private final ExpenditureMapper expenditureMapper;
    private final IncomeMapper incomeMapper;

    public StatisticsService(ExpenditureMapper expenditureMapper, IncomeMapper incomeMapper) {
        this.expenditureMapper = expenditureMapper;
        this.incomeMapper = incomeMapper;
    }

    /**
     * 获取所有支出收入信息
     *
     * @return
     */
    public List<StatisticsOutput> getList() {
        LambdaQueryWrapper<StatisticsVO> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(StatisticsVO::getAddTime);
        return new StatisticsOutput().convert(this.list(wrapper));
    }

    public Map<String, Double> statisticalData() {
        Map<String, Double> map = new HashMap<>(16);
        Double totalIncome = incomeMapper.getTotalIncome(UserUtils.getCurrentUser().getId());
        Double totalExpenditure = expenditureMapper.getTotalExpenditure(UserUtils.getCurrentUser().getId());
        Double remainingBalance = totalIncome - totalExpenditure;
        map.put("totalIncome", totalIncome);
        map.put("totalExpenditure", totalExpenditure);
        map.put("remainingBalance", remainingBalance);
        return map;
    }

    public List<IconData> iconData() {
        return expenditureMapper.iconData(UserUtils.getCurrentUser().getId());
    }

}
