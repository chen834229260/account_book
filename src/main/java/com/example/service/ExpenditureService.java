package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.enmu.ExpenditureEnum;
import com.example.mapper.ExpenditureMapper;
import com.example.util.UserUtils;
import com.example.vo.ExpenditureVO;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: ckx
 * @date: 2020/3/2
 * @description:支出
 */
@Service
public class ExpenditureService extends ServiceImpl<ExpenditureMapper, ExpenditureVO> {
    /**
     * 添加
     *
     * @param expenditureVO
     */
    public Boolean addExpenditure(ExpenditureVO expenditureVO) {
        expenditureVO.setUserId(UserUtils.getCurrentUser().getId());
        expenditureVO.setAddTime(DateUtil.currentSeconds());
        expenditureVO.setCategory(ExpenditureEnum.getCode(Integer.valueOf(expenditureVO.getCategory())));
        return this.save(expenditureVO);
    }

    public List<Double> monthlyExpenditureStatistics() throws ParseException {
        List<ExpenditureVO> list = this.list();
        List<Double> resultTotalList = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            String time = i >= 10 ? "2021-" + i + "-01T00:00:00" : "2021-0" + i + "-01T00:00:00";
            LocalDateTime today = LocalDateTime.parse(time);
            //本月的第一天
            LocalDate firstDay = LocalDate.of(today.getYear(), today.getMonth(), 1);
            LocalDateTime lastDay = today.with(TemporalAdjusters.lastDayOfMonth());
            String start = firstDay + " 00:00:00";
            String end = lastDay.toLocalDate() + " 23:59:59";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date startDate = simpleDateFormat.parse(start);
            Date endDate = simpleDateFormat.parse(end);
            Long startTime = startDate.getTime() / 1000L;
            Long endTime = endDate.getTime() / 1000L;
            List<ExpenditureVO> resultList = list.stream().filter(s -> s.getAddTime() <= endTime && s.getAddTime() >= startTime).collect(Collectors.toList());
            Double total = 0.0;
            for (ExpenditureVO sv : resultList) {
                total += sv.getMoney();
            }
            resultTotalList.add(total);
        }
        return resultTotalList;
    }
}
