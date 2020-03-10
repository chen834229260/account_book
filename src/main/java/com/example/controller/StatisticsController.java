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
    @RequestMapping("/getTotalExpenses")
    public ResultDTO getTotalExpenses() {
        return new ResultDTO(service.getTotalExpenses(), CodeStatus.SUCCESS);
    }

    /**
     * 获取总收入
     *
     * @return
     */
    @RequestMapping("/getTotalIncome")
    public ResultDTO getTotalIncome() {
        return new ResultDTO(service.getTotalIncome(), CodeStatus.SUCCESS);
    }

    @RequestMapping("/remainingBalance")
    public ResultDTO remainingBalance() {
        return new ResultDTO(service.remainingBalance(), CodeStatus.SUCCESS);
    }
}
