package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.enmu.ExpenditureEnum;
import com.example.mapper.IncomeMapper;
import com.example.util.UserUtils;
import com.example.vo.IncomeVO;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: ckx
 * @date: 2020/3/2
 * @description:收入
 */
@Service
public class IncomeService extends ServiceImpl<IncomeMapper, IncomeVO> {

    public boolean add(IncomeVO incomeVO) {
        incomeVO.setAddTime(DateUtil.currentSeconds());
        incomeVO.setCategory(ExpenditureEnum.getCode(Integer.valueOf(incomeVO.getCategory())));
        incomeVO.setUserId(UserUtils.getCurrentUser().getId());
        return this.save(incomeVO);
    }

    public List<Double> monthlyIncomeStatistics() throws ParseException {
        List<IncomeVO> list = this.list();
        List<Double> resultTotalList = new ArrayList<>();
        int currentMonth = LocalDate.now().getMonthValue();
        for (int i = 13; i > 1; i--) {
            int temp = currentMonth  - i - 10;
            if (temp > currentMonth) {
                temp -= temp * 2;
            }
            String monthStart = LocalDate.now().plusMonths(temp).with(TemporalAdjusters.firstDayOfMonth()) + " 00:00:00";
            String monthEnd = LocalDate.now().plusMonths(temp).with(TemporalAdjusters.lastDayOfMonth()) + " 23:59:59";
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Long monthStartTime = format.parse(monthStart).getTime() / 1000L;
            Long monthEndTime = format.parse(monthEnd).getTime() / 1000L;
            List<IncomeVO> resultList = list.stream().filter(s -> s.getAddTime() <= monthEndTime && s.getAddTime() >= monthStartTime).collect(Collectors.toList());
            Double total = 0.0;
            for (IncomeVO sv:resultList){
                total += sv.getMoney();
            }
            resultTotalList.add(total);
        }
        return resultTotalList;
    }
}