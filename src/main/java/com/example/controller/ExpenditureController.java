package com.example.controller;

import com.example.service.ExpenditureService;
import com.example.vo.ExpenditureVO;
import com.example.vo.ResultDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ckx
 * @date: 2020/3/3
 * @description:支出消费
 */

@RestController
@RequestMapping("/expenditure")
public class ExpenditureController {
    private final ExpenditureService service;

    public ExpenditureController(ExpenditureService service) {
        this.service = service;
    }

    @RequestMapping("/add")
    @ResponseBody
    public ResultDTO add(ExpenditureVO expenditureVO){
        return new ResultDTO(service.addExpenditure(expenditureVO));
    }
}
