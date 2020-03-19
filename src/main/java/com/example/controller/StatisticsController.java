package com.example.controller;

import com.example.enmu.CodeStatus;
import com.example.service.StatisticsService;
import com.example.vo.ResultDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ckx
 * @date: 2020/3/9
 * @description:
 */
@RestController
@RequestMapping("/statistics")
public class StatisticsController {
    private final StatisticsService service;

    public StatisticsController(StatisticsService service) {
        this.service = service;
    }

    @RequestMapping("/getList")
    public ResultDTO getList() {
        return new ResultDTO(service.getList(), CodeStatus.SUCCESS);
    }

    /**
     * 获取总支出
     *
     * @return
     */
    @RequestMapping("/statisticalData")
    public ResultDTO statisticalData() {
        return new ResultDTO(service.statisticalData(), CodeStatus.SUCCESS);
    }

    /**
     * 饼图数据获取
     *
     * @return
     */
    @RequestMapping("/iconData")
    public ResultDTO iconData() {
        return new ResultDTO(service.iconData(),CodeStatus.SUCCESS);
    }

}
