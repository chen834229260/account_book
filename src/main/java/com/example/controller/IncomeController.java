package com.example.controller;

import com.example.service.IncomeService;
import com.example.vo.IncomeVO;
import com.example.vo.ResultDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ckx
 * @date: 2020/3/3
 * @description:收入
 */
@RestController
@RequestMapping("/income")
public class IncomeController {

    private final IncomeService service;

    public IncomeController(IncomeService service) {
        this.service = service;
    }

    @RequestMapping("/add")
    @ResponseBody
    public ResultDTO add(IncomeVO incomeVO){
        return new ResultDTO(service.add(incomeVO));
    }
}
