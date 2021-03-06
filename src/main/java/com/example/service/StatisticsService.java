package com.example.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.ExpenditureMapper;
import com.example.mapper.IncomeMapper;
import com.example.mapper.StatisticsMapper;
import com.example.util.UserUtils;
import com.example.vo.StatisticsVO;
import com.example.vo.output.BeanOuput;
import com.example.vo.output.StatisticsOutput;
import com.example.vo.query.QueryStatisticsVO;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
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
    private final ExpenditureService expenditureService;
    private final IncomeService incomeService;

    public StatisticsService(ExpenditureMapper expenditureMapper, IncomeMapper incomeMapper,
                             IncomeService incomeService, ExpenditureService expenditureService) {
        this.expenditureMapper = expenditureMapper;
        this.incomeMapper = incomeMapper;
        this.expenditureService = expenditureService;
        this.incomeService = incomeService;
    }

    /**
     * 获取所有支出收入信息
     *
     * @return
     */
    public BeanOuput<StatisticsOutput> getList(QueryStatisticsVO input) {
        LambdaQueryWrapper<StatisticsVO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StatisticsVO::getUserId, UserUtils.getCurrentUser().getId())
                .orderByDesc(StatisticsVO::getAddTime);
        IPage<StatisticsVO> page = new Page<>(input.getPage(), input.getLimit());
        IPage<StatisticsVO> listPage = this.page(page, wrapper);
        BeanOuput<StatisticsOutput> bean = new BeanOuput<>();
        bean.setRecords(new StatisticsOutput().convert(listPage.getRecords()));
        bean.setTotal(listPage.getTotal());
        return bean;
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

    public List<List<Double>> iconData() throws ParseException {
        List<List<Double>> result = new ArrayList<>();
        List<Double> incomeTotal = incomeService.monthlyIncomeStatistics();
        result.add(incomeTotal);
        List<Double> expenditureTotal = expenditureService.monthlyExpenditureStatistics();
        result.add(expenditureTotal);
        return result;
    }
}
