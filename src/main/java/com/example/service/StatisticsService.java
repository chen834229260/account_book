package com.example.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.ExpenditureMapper;
import com.example.mapper.IncomeMapper;
import com.example.mapper.StatisticsMapper;
import com.example.vo.StatisticsVO;
import com.example.vo.output.StatisticsOutput;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        List<StatisticsVO> list = this.list().stream().sorted(Comparator.comparing(StatisticsVO::getAddTime))
                .collect(Collectors.toList());
        return new StatisticsOutput().convert(list);
    }

    public Double getTotalIncome() {
        return incomeMapper.getTotalIncome();

    }

    public Double getTotalExpenses() {
        return expenditureMapper.getTotalExpenditure();
    }

    public Double remainingBalance() {
        return incomeMapper.getTotalIncome() - expenditureMapper.getTotalExpenditure();
    }
}
