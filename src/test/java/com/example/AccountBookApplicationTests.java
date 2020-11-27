package com.example;


import com.example.service.ExpenditureService;
import com.example.vo.ExpenditureVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author MTR-007
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountBookApplicationTests {

    @Autowired
    ExpenditureService expenditureService;

    @Test
    public void test1() throws ParseException {
        List<ExpenditureVO> list = expenditureService.list();
        List<Double> resultTotalList = new ArrayList<>();
        int currentMonth = LocalDate.now().getMonthValue();
        for (int i = 13; i > 1; i--) {
            int temp = currentMonth - i - 2;
            if (temp > currentMonth) {
                temp -= temp * 2;
            }
            String monthStart = LocalDate.now().plusMonths(temp).with(TemporalAdjusters.firstDayOfMonth()) + " 00:00:00";
            String monthEnd = LocalDate.now().plusMonths(temp).with(TemporalAdjusters.lastDayOfMonth()) + " 23:59:59";
            System.out.println(monthStart);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Long monthStartTime = format.parse(monthStart).getTime() / 1000L;
            Long monthEndTime = format.parse(monthEnd).getTime() / 1000L;
            List<ExpenditureVO> resultList = list.stream().filter(s -> s.getAddTime() <= monthEndTime && s.getAddTime() >= monthStartTime).collect(Collectors.toList());
            Double total = 0.0;
            for (ExpenditureVO sv:resultList){
                total += sv.getMoney();
            }
            resultTotalList.add(total);
        }
        resultTotalList.stream().forEach(System.out::println);
    }


}
