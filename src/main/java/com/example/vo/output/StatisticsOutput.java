package com.example.vo.output;

import cn.hutool.core.bean.BeanUtil;
import com.example.vo.StatisticsVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: ckx
 * @date: 2020/3/10
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatisticsOutput {

    private Integer userId;

    private Double money;

    private String category;

    private Long addTime;

    private String addTimeStr;


    public StatisticsOutput convert(StatisticsVO problenVO) {
        StatisticsOutput.InsertConvert courseInsertConvert = new StatisticsOutput.InsertConvert();
        return courseInsertConvert.convert(problenVO);
    }

    public List<StatisticsOutput> convert(List<StatisticsVO> list) {
        StatisticsOutput.InsertConvert courseInsertConvert = new StatisticsOutput.InsertConvert();
        return courseInsertConvert.convert(list);
    }

    private static class InsertConvert implements BeanConvert<StatisticsVO, StatisticsOutput> {

        @Override
        public StatisticsOutput convert(StatisticsVO statisticsVO) {
            StatisticsOutput statisticsOutput = new StatisticsOutput();
            BeanUtil.copyProperties(statisticsVO, statisticsOutput);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String newDate = sdf.format(new Date(Long.valueOf(statisticsOutput.getAddTime() + "000")));
            statisticsOutput.setAddTimeStr(newDate);
            return statisticsOutput;
        }

        @Override
        public List<StatisticsOutput> convert(List<StatisticsVO> list) {
            List<StatisticsOutput> outputList = new ArrayList<>();
            for (StatisticsVO statisticsVO : list) {
                outputList.add(this.convert(statisticsVO));
            }
            return outputList;
        }
    }
}
